package com.cloud.springcloud.Chargeservice.entity;

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
 * 用水信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_water")
@ApiModel(value="Water对象", description="用水信息")
public class Water implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用水序列id")
    @TableId(value = "W_ID", type = IdType.AUTO)
    private Integer wId;

    @ApiModelProperty(value = "房间id")
    @TableField("W_BU_ID")
    private Integer wBuId;

    @ApiModelProperty(value = "抄表时间")
    @TableField("W_GMT")
    private Date wGmt;

    @ApiModelProperty(value = "本月抄表数值")
    @TableField("W_NUM")
    private BigDecimal wNum;

    @ApiModelProperty(value = "本月应缴费用")
    @TableField("W_MONEY")
    private BigDecimal wMoney;


}
