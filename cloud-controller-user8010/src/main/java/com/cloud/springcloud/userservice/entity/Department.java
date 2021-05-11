package com.cloud.springcloud.userservice.entity;

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
 * 部门信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Department对象", description="部门信息")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工id")
    @TableId(value = "DP_ID", type = IdType.AUTO)
    private Integer dpId;

    @ApiModelProperty(value = "部门名称")
    @TableField("DP_NAME")
    private String dpName;

    @ApiModelProperty(value = "部门介绍")
    @TableField("DP_INTER")
    private String dpInter;

    @ApiModelProperty(value = "部门主管ID")
    @TableField("DP_SUPERID")
    private Integer dpSuperid;


}
