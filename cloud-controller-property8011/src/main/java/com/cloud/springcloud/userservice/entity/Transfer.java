package com.cloud.springcloud.userservice.entity;

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
 * 调库申请信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_transfer")
@ApiModel(value="Transfer对象", description="调库申请信息")
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "申请序列")
    @TableId(value = "T_ID", type = IdType.AUTO)
    private Integer tId;

    @ApiModelProperty(value = "物品id")
    @TableField("T_INID")
    private Integer tInid;

    @ApiModelProperty(value = "物品名称")
    @TableField("T_NAME")
    private String tName;

    @ApiModelProperty(value = "申请人id")
    @TableField("T_STAFF_ID")
    private Integer tStaffId;

    @ApiModelProperty(value = "申请数量")
    @TableField("T_NUM")
    private Integer tNum;

    @ApiModelProperty(value = "申请状态 0待审批  1已同意  -1拒绝")
    @TableField("T_STATE")
    private Integer tState;


}
