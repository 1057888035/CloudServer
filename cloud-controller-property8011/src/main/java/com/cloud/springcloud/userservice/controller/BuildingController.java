package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.ExcelUtils;
import com.cloud.springcloud.entities.entity.Building;
import com.cloud.springcloud.userservice.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房间信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/userservice/building")
public class BuildingController {
    @Autowired
    BuildingService buildingService;

    @PostMapping(value = "/saveBuilding" ,name = "新增房间信息")
    public CommonResult saveBuilding(@RequestBody Building building){
        boolean b = buildingService.saveBuilding(building);
        if (b){
            return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"false");
        }
    }

    @PostMapping(value = "/project/import")
    public CommonResult importAlarmEvents(@RequestBody MultipartFile file) {
        System.out.println(file.toString());
        try {
            // 从Excel第一行起到最后一行结束,
            List<List<Object>> excelData = ExcelUtils.importExcelMultipartFile(file, 1, 0, Building.class);
            if (excelData == null || excelData.isEmpty()) {
               return  new CommonResult(400,"数据为空");
            }
            //将Excel中数据，转为你的实体类
            List<List<Building>> alarmList = new ArrayList<>();
            for (List<?> list : excelData) {
                alarmList.add((List<Building>) list);
            }
            boolean b = buildingService.saveBatch(alarmList.get(0));
        } catch (Exception e) {
            return  new CommonResult(400,e.toString());
        }
         return  new CommonResult(200,"成功");
    }


    @GetMapping(value = "/getBuilding/{pn}" ,name = "查询所有房间")
    public CommonResult<Page<Building>> getBuilding(@PathVariable("pn")Integer pn){
        return buildingService.getBuilding(pn);
    }

    @GetMapping(value = "/getBuildingForCode/{code}" ,name = "根据房间号查询房间")
    public CommonResult<Page<Building>> getBuildingForCode(@PathVariable("code") Integer code){
        return buildingService.getBuildingForCode(code);
    }
    @GetMapping(value = "/getBuildingForOwnerId/{id}" ,name = "根据用户id查询房间")
    public CommonResult<Page<Building>> getBuildingForOwnerId(@PathVariable("id") Integer id){
        return buildingService.getBuildingForOwnerId(id);
    }

    @PostMapping(value = "/updateforid" ,name = "根据id跟新")
    public CommonResult updateForId(@RequestBody Building building){
        return buildingService.updateForId(building);
    }

    @GetMapping(value = "/deleteForId/{ids}" ,name = "根据id删除一个或多个房间信息")
    public CommonResult deleteForId(@PathVariable("ids")String ids){

        if (ids.contains("-")){
            //批量删除
            List<Integer> del_ids =new ArrayList<>();
            String[] str_ids = ids.split("-");
            /*组装id的集合*/
            for (String string :str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            return buildingService.deleteForArryId(del_ids);

        }else {
            Integer id = Integer.parseInt(ids);
            return   buildingService.deleteForId(id);
        }

    }

}

