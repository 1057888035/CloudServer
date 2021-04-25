package com.cloud.springcloud.entities.entity;

import java.math.BigDecimal;
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
 * 用气信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_gas")
@ApiModel(value="Gas对象", description="用气信息")
public class Gas implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用水序列id")
    @TableId(value = "G_ID", type = IdType.AUTO)
    private Integer gId;

    @ApiModelProperty(value = "房间id")
    @TableField("G_BU_ID")
    private Integer gBuId;

    @ApiModelProperty(value = "抄表时间")
    @TableField("G_GMT")
    private Date gGmt;

    @ApiModelProperty(value = "本月抄表数值")
    @TableField("G_NUM")
    private BigDecimal gNum;

    @ApiModelProperty(value = "本月应缴费用")
    @TableField("G_MONEY")
    private BigDecimal gMoney;


}
