package com.cloud.springcloud.entities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;



public class ExcelUtils {

    private static final String REGEX = "[a-zA-Z]";

    private static final Logger log = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * @param multipartFile
     * @param startRow      开始行
     * @param endRow        结束行（0表示到最后一行结束）
     * @param clazz
     * @return
     * @throws Exception
     */
    public static List<List<Object>> importExcelMultipartFile(MultipartFile multipartFile, int startRow, int endRow,
                                                              Class<?> clazz) throws Exception {
        // 判断文件是否存在
        if (multipartFile == null || multipartFile.isEmpty()) {
            throw new IOException("Excel文件内容为空或不存在！");
        }
        String name = "Excel" + System.currentTimeMillis();
        File file = File.createTempFile(name, null);
        multipartFile.transferTo(file);
        if (!file.exists()) {
            throw new IOException("文件名为" + file.getName() + "Excel文件不存在！");
        }
        return importExcelFile(file, startRow, endRow, clazz);
    }

    /**
     * 根据文件导入Excel，仅导入数据，去除校验
     *
     * @param file     文件
     * @param startRow 开始行，从0开始
     * @param endRow   结束行，0表示所有行; 正数表示到第几行结束; 负数表示到倒数第几行结束
     * @param clazz    sheet需要映射的对象类型
     * @return List<List < Object>>
     * @throws Exception
     */
    public static List<List<Object>> importExcelFile(File file, int startRow, int endRow, Class<?> clazz)
            throws Exception {
        List<List<Object>> sheetsData = new ArrayList<>();
        // 判断文件是否存在
        if (!file.exists()) {
            throw new IOException("文件名为" + file.getName() + "Excel文件不存在！");
        }
        Workbook wb = null;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            // 工厂模式，根据Excel版本（2003版以前版本，或其他版本），创建对应的工作薄处理类
            wb = WorkbookFactory.create(inputStream);
            for (int sheetNumber = 0; sheetNumber < wb.getNumberOfSheets(); sheetNumber++) {
                List<Row> rowList = new ArrayList<Row>();
                Sheet sheet = wb.getSheetAt(sheetNumber);
                // 获取最后行号
                int lastRowNum = sheet.getLastRowNum();
                Row row = null;
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                // 循环读取
                for (int i = startRow; i <= lastRowNum + endRow; i++) {
                    // 是否全部单元格都为空
                    boolean isEmptyRow = true;
                    row = sheet.getRow(i);
                    if (row != null) {
                        // 获取每一单元格的值
                        for (int j = 0; j < row.getLastCellNum(); j++) {
                            String value = p.matcher(getCellValue(row.getCell(j))).replaceAll("");
                            if (!value.trim().equals("")) {
                                isEmptyRow = false;
                            }
                        }
                        // 校验规则：如果是空白行，没有数据，仅有空格符、制表符等字符（用户无意间输入的字符），则应该过滤掉。
                        if (!isEmptyRow) {
                            // 该行数据中存在非空单元格，则返回该行
                            rowList.add(row);
                        }
                    }
                }
                sheetsData.add(returnObjectList(rowList, clazz));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (wb != null) {
                wb.close();
            }
        }
        return sheetsData;
    }

    /**
     * 功能:返回指定的对象集合
     */
    private static List<Object> returnObjectList(List<Row> rowList, Class<?> clazz) {
        List<Object> objectList = null;
        Object obj = null;
        String attribute = null;
        String value = null;
        int j = 0;
        try {
            objectList = new ArrayList<Object>();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Row row : rowList) {
                j = 0;
                obj = clazz.newInstance();
                for (Field field : declaredFields) {
                    try {
                        attribute = field.getName().toString();
                        value = getCellValue(row.getCell(j));
                        setAttrributeValue(obj, attribute, value.trim());
                        j++;
                    } catch (Exception e) {
                        log.info("属性映射出错，属性名：" + attribute + "属性值：" + value);
                        e.printStackTrace();
                    }
                }
                // 仅提取没有非空字段的对象
                objectList.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectList;
    }

    /**
     * 功能:获取单元格的值
     */
    @SuppressWarnings("deprecation")
    private static String getCellValue(Cell cell) {
        Object result = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    result = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    result = cell.getNumericCellValue();
                    break;
                case BOOLEAN:
                    result = cell.getBooleanCellValue();
                    break;
                case FORMULA:
                    result = cell.getCellFormula();
                    break;
                case ERROR:
                    result = cell.getErrorCellValue();
                    break;
                case BLANK:
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }

    /**
     * 功能:给指定对象的指定属性赋值
     */
    private static void setAttrributeValue(Object obj, String attribute, String value) {
        if (value == null || value.trim().equals("")) {
            return;
        }
        // 得到该属性的set方法名
        String method_name = convertToMethodName(attribute, obj.getClass(), true);
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            /**
             * 因为这里只是调用bean中属性的set方法，属性名称不能重复 所以set方法也不会重复，所以就直接用方法名称去锁定一个方法 （注：在java中，锁定一个方法的条件是方法名及参数）
             */
            if (method.getName().equals(method_name)) {
                Class<?>[] parameterC = method.getParameterTypes();
                try {
                    /**
                     * 如果是(整型,浮点型,布尔型,字节型,时间类型), 按照各自的规则把value值转换成各自的类型 否则一律按类型强制转换(比如:String类型)
                     */
                    if (parameterC[0] == int.class || parameterC[0] == java.lang.Integer.class) {
                        int index = value.lastIndexOf(".");
                        if (index != -1) {
                            value = value.substring(0, index);
                        }
                        try {
                            method.invoke(obj, Integer.valueOf(value));
                        } catch (Exception e) {
                            System.out.println(value);
                            e.printStackTrace();
                        }
                        break;
                    } else if (parameterC[0] == float.class || parameterC[0] == java.lang.Float.class) {
                        method.invoke(obj, Float.valueOf(value));
                        break;
                    } else if (parameterC[0] == double.class || parameterC[0] == java.lang.Double.class) {
                        method.invoke(obj, Double.valueOf(value));
                        break;
                    } else if (parameterC[0] == byte.class || parameterC[0] == java.lang.Byte.class) {
                        method.invoke(obj, Byte.valueOf(value));
                        break;
                    } else if (parameterC[0] == boolean.class || parameterC[0] == java.lang.Boolean.class) {
                        method.invoke(obj, Boolean.valueOf(value));
                        break;
                    } else if (parameterC[0] == java.util.Date.class) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                        Date date = null;
                        try {
                            date = sdf.parse(value);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        method.invoke(obj, date);
                        break;
                    } else {
                        method.invoke(obj, parameterC[0].cast(value));
                        break;
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 功能:根据属性生成对应的set/get方法
     */
    private static String convertToMethodName(String attribute, Class<?> objClass, boolean isSet) {
        /** 通过正则表达式来匹配第一个字符 **/
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(attribute);
        StringBuilder sb = new StringBuilder();
        /** 如果是set方法名称 **/
        if (isSet) {
            sb.append("set");
        } else {
            /** get方法名称 **/
            try {
                Field attributeField = objClass.getDeclaredField(attribute);
                /** 如果类型为boolean **/
                if (attributeField.getType() == boolean.class || attributeField.getType() == Boolean.class) {
                    sb.append("is");
                } else {
                    sb.append("get");
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        /** 针对以下划线开头的属性 **/
        if (attribute.charAt(0) != '_' && m.find()) {
            sb.append(m.replaceFirst(m.group().toUpperCase()));
        } else {
            sb.append(attribute);
        }
        return sb.toString();
    }

}
