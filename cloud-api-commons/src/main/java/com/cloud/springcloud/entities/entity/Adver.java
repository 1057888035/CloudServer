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
 * 广告信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_adver")
@ApiModel(value="Adver对象", description="广告信息")
public class Adver implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "存储序列")
    @TableId(value = "AD_ID", type = IdType.AUTO)
    private Integer adId;

    @ApiModelProperty(value = "广告名称")
    @TableField("AD_KEY")
    private String adKey;

    @ApiModelProperty(value = "广告内容")
    @TableField("AD_VALUE")
    private String adValue;

    @ApiModelProperty(value = "广告投放位置")
    @TableField("AD_POSITION")
    private Integer adPosition;

    @ApiModelProperty(value = "创建时间")
    @TableField("GMT_CREATE")
    private Date gmtCreate;

    @ApiModelProperty(value = "广告状态 0关闭 1开启")
    @TableField("AD_STATE")
    private Integer adState;


}
