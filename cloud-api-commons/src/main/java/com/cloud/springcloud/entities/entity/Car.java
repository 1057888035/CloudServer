package com.cloud.springcloud.entities.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 车辆信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_car")
@ApiModel(value="Car对象", description="车辆信息")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车辆id")
    @TableId(value = "C_ID", type = IdType.AUTO)
    private Integer cId;

    @ApiModelProperty(value = "车牌号")
    @TableField("C_NUM")
    private String cNum;

    @ApiModelProperty(value = "车主姓名")
    @TableField("C_NAME")
    private String cName;

    @ApiModelProperty(value = "车主联系电话")
    @TableField("C_PHONE")
    private String cPhone;

    @ApiModelProperty(value = "注册时间")
    @TableField("C_REGIST")
    private Date cRegist;


}
