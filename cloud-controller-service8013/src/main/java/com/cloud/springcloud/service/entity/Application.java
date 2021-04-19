package com.cloud.springcloud.service.entity;

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
 * 客户申请信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_application")
@ApiModel(value="Application对象", description="客户申请信息")
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "存储序列")
    @TableId(value = "A_ID", type = IdType.AUTO)
    private Integer aId;

    @ApiModelProperty(value = "申请主题")
    @TableField("A_THEME")
    private String aTheme;

    @ApiModelProperty(value = "申请内容")
    @TableField("A_CONTENT")
    private String aContent;

    @ApiModelProperty(value = "申请人姓名")
    @TableField("A_NAME")
    private String aName;

    @ApiModelProperty(value = "联系电话")
    @TableField("A_PHONE")
    private String aPhone;

    @ApiModelProperty(value = "申请时间")
    @TableField("GTM_START")
    private Date gtmStart;

    @ApiModelProperty(value = "解决时间")
    @TableField("GMT_END")
    private Date gmtEnd;

    @ApiModelProperty(value = "安排工作人员id")
    @TableField("A_STAFF_ID")
    private Integer aStaffId;

    @ApiModelProperty(value = "工作人员到岗状态 0等待 1到岗位")
    @TableField("A_STAFF_STATE")
    private Integer aStaffState;

    @ApiModelProperty(value = "申请状态 0待解决 1已解决 -1客户取消")
    @TableField("A_STATE")
    private Integer aState;


}
