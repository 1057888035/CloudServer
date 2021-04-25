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
 * 物业费用信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_property")
@ApiModel(value="Property对象", description="物业费用信息")
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "存储序列")
    @TableId(value = "PR_ID", type = IdType.AUTO)
    private Integer prId;

    @ApiModelProperty(value = "楼栋编号")
    @TableField("BU_ID")
    private Integer buId;

    @ApiModelProperty(value = "入账日期")
    @TableField("PR_GMT")
    private Date prGmt;

    @ApiModelProperty(value = "应缴费用")
    @TableField("PR_MONEY")
    private BigDecimal prMoney;

    @ApiModelProperty(value = "缴纳状态 0未缴纳 1已缴纳")
    @TableField("PR_STATE")
    private Integer prState;


}
