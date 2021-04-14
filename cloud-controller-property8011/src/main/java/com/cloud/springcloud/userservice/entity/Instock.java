package com.cloud.springcloud.userservice.entity;

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
 * 房间信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_instock")
@ApiModel(value="Instock对象", description="房间信息")
public class Instock implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "物品id")
    @TableId(value = "I_ID", type = IdType.AUTO)
    private Integer iId;

    @ApiModelProperty(value = "物品名称")
    @TableField("I_NAME")
    private String iName;

    @ApiModelProperty(value = "物品重量 /kg")
    @TableField("I_WEIGHT")
    private BigDecimal iWeight;

    @ApiModelProperty(value = "生产日期")
    @TableField("GMT_PR")
    private Date gmtPr;

    @ApiModelProperty(value = "过期日期")
    @TableField("GMT_EX")
    private Date gmtEx;

    @ApiModelProperty(value = "购入价格")
    @TableField("I_MONEY")
    private BigDecimal iMoney;

    @ApiModelProperty(value = "购入人id")
    @TableField("I_STAFF_ID")
    private Integer iStaffId;

    @ApiModelProperty(value = "库存数量")
    @TableField("I_NUM")
    private Integer iNum;


}
