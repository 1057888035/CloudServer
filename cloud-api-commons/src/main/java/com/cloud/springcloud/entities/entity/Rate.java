package com.cloud.springcloud.entities.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 收费费率信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_rate")
@ApiModel(value="Rate对象", description="收费费率信息")
public class Rate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "存储序列")
    @TableId(value = "R_ID", type = IdType.AUTO)
    private Integer rId;

    @ApiModelProperty(value = "费率名称")
    @TableField("R_NAME")
    private String rName;

    @ApiModelProperty(value = "费率金额")
    @TableField("R_RATE")
    private BigDecimal rRate;

    @ApiModelProperty(value = "单位")
    @TableField("R_UNIT")
    private String rUnit;


}
