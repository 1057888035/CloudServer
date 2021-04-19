package com.cloud.springcloud.configservice.entity;

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
 * 支付配置信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_fchannel")
@ApiModel(value="Fchannel对象", description="支付配置信息")
public class Fchannel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "存储序列")
    @TableId(value = "F_ID", type = IdType.AUTO)
    private Integer fId;

    @ApiModelProperty(value = "渠道编码")
    @TableField("F_CONFIG_CODE")
    private String fConfigCode;

    @ApiModelProperty(value = "渠道名称")
    @TableField("F_NAME")
    private String fName;

    @ApiModelProperty(value = "渠道方式")
    @TableField("F_CODE")
    private String fCode;

    @ApiModelProperty(value = "配置名称")
    @TableField("F_CONFIG_NAME")
    private String fConfigName;

    @ApiModelProperty(value = "针对用户显示 0不显示 1显示")
    @TableField("F_CONFIG_SHOW")
    private Integer fConfigShow;

    @ApiModelProperty(value = "配置key")
    @TableField("F_CONFIG_KEY")
    private String fConfigKey;

    @TableField("F_CONFIG_VALUE")
    private String fConfigValue;

    @ApiModelProperty(value = "配置状态 0关闭 1开启")
    @TableField("F_STATE")
    private Integer fState;


}
