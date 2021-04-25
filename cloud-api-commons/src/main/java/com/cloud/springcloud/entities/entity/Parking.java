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
 * 车位信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_parking")
@ApiModel(value="Parking对象", description="车位信息")
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车位id")
    @TableId(value = "P_ID", type = IdType.AUTO)
    private Integer pId;

    @ApiModelProperty(value = "车牌号")
    @TableField("P_NUM")
    private String pNum;

    @ApiModelProperty(value = "联系人姓名")
    @TableField("P_NAME")
    private String pName;

    @ApiModelProperty(value = "联系人电话")
    @TableField("P_PHONE")
    private String pPhone;

    @ApiModelProperty(value = "车位状态 0为空 1已售出 2出租")
    @TableField("P_STATE")
    private Integer pState;

    @ApiModelProperty(value = "出售时间")
    @TableField("PG_START")
    private Date pgStart;

    @ApiModelProperty(value = "到期时间")
    @TableField("PG_END")
    private Date pgEnd;


}
