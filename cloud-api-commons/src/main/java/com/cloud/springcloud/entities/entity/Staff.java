package com.cloud.springcloud.entities.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * <p>
 * 员工信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_staff")
@ApiModel(value="Staff对象", description="员工信息")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工id")
    @TableId(value = "S_ID", type = IdType.AUTO)
    private Integer sId;

    @ApiModelProperty(value = "电话号码")
    @TableField("S_PHONE")
    private String sPhone;

    @ApiModelProperty(value = "登录密码")
    @TableField("S_PASSWORD")
    private String sPassword;

    @ApiModelProperty(value = "员工姓名")
    @TableField("S_NAME")
    private String sName;


    @ApiModelProperty(value = "出生日期")
    @TableField("S_BIRTHDAY")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sBirthday;

    @ApiModelProperty(value = "入职日期")
    @TableField("S_REGIST")
    private Date sRegist;

    @ApiModelProperty(value = "离职日期")
    @TableField("S_RESOGM")
    private Date sResogm;

    @ApiModelProperty(value = "部门编号")
    @TableField("S_DEPARTMENT_ID")
    private Integer sDepartmentId;

    @ApiModelProperty(value = "家庭住址")
    @TableField("S_ADDRESS")
    private String sAddress;

    @ApiModelProperty(value = "员工状态 0空闲 1在岗 2休息 -1离职")
    @TableField("S_STATE")
    private Integer sState;

    @ApiModelProperty(value = "员工类型 0是系统管理员 1普通员工")
    @TableField("S_TYPE")
    private Integer sType;


}
