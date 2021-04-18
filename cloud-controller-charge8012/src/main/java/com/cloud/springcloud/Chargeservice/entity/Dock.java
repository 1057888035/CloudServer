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
 * 停车收费信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_dock")
@ApiModel(value="Dock对象", description="停车收费信息")
public class Dock implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "存储序列")
    @TableId(value = "DO_ID", type = IdType.AUTO)
    private Integer doId;

    @ApiModelProperty(value = "车牌号码")
    @TableField("DO_NUM")
    private String doNum;

    @ApiModelProperty(value = "进入时间")
    @TableField("GMT_IN")
    private Date gmtIn;

    @ApiModelProperty(value = "离开时间")
    @TableField("GMT_OUT")
    private Date gmtOut;

    @ApiModelProperty(value = "应缴费用")
    @TableField("DO_MONEY")
    private BigDecimal doMoney;

    @ApiModelProperty(value = "缴费状态 0未缴纳 1已缴纳")
    @TableField("DO_STATE")
    private Integer doState;


}
