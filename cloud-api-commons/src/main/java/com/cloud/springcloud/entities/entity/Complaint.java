package com.cloud.springcloud.entities.entity;

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
 * 客诉信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_complaint")
@ApiModel(value="Complaint对象", description="客诉信息")
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "存储序列")
    @TableId(value = "C_ID", type = IdType.AUTO)
    private Integer cId;

    @ApiModelProperty(value = "投诉内容")
    @TableField("C_VALUE")
    private String cValue;

    @ApiModelProperty(value = "投诉用户名")
    @TableField("C_USER_NAME")
    private String cUserName;

    @ApiModelProperty(value = "联系电话")
    @TableField("C_PHONE")
    private String cPhone;

    @ApiModelProperty(value = "回复内容")
    @TableField("C_MNS")
    private String cMns;

    @ApiModelProperty(value = "投诉状态 0待解决 1已解决 -1客户取消")
    @TableField("C_STATE")
    private Integer cState;


}
