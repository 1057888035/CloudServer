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
 * 用电信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_power")
@ApiModel(value="Power对象", description="用电信息")
public class Power implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用水序列id")
    @TableId(value = "PW_ID", type = IdType.AUTO)
    private Integer pwId;

    @ApiModelProperty(value = "房间id")
    @TableField("PW_BU_ID")
    private Integer pwBuId;

    @ApiModelProperty(value = "抄表时间")
    @TableField("PW_GMT")
    private Date pwGmt;

    @ApiModelProperty(value = "本月抄表数值")
    @TableField("PW_NUM")
    private BigDecimal pwNum;

    @ApiModelProperty(value = "本月应缴费用")
    @TableField("PW_MONEY")
    private BigDecimal pwMoney;


}
