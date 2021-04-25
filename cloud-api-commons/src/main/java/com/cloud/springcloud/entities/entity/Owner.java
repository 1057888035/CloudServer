package com.cloud.springcloud.entities.entity;

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
 * 业主信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_owner")
@ApiModel(value="Owner对象", description="业主信息")
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "业主id")
    @TableId(value = "O_ID", type = IdType.AUTO)
    private Integer oId;

    @ApiModelProperty(value = "用户名")
    @TableField("O_USER")
    private String oUser;

    @ApiModelProperty(value = "密码")
    @TableField("O_PASSWORD")
    private String oPassword;

    @ApiModelProperty(value = "业主姓名")
    @TableField("O_NAME")
    private String oName;

    @ApiModelProperty(value = "出生日期")
    @TableField("O_BIRTHDAY")
    private Date oBirthday;

    @ApiModelProperty(value = "注册日期")
    @TableField("O_REGIST")
    private Date oRegist;

    @ApiModelProperty(value = "电话号码")
    @TableField("O_PHONE")
    private String oPhone;

    @ApiModelProperty(value = "身份证号码")
    @TableField("O_IDCAR")
    private String oIdcar;

    @ApiModelProperty(value = "籍贯")
    @TableField("O_HOMETOWN")
    private String oHometown;

    @ApiModelProperty(value = "头像路径")
    @TableField("O_PHOTO")
    private String oPhoto;

    @ApiModelProperty(value = "状态 0为禁用 1为启用")
    @TableField("O_STATE")
    private Integer oState;


}
