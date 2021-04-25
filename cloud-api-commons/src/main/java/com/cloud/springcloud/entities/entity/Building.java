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
 * 房间信息
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_building")
@ApiModel(value="Building对象", description="房间信息")
public class Building implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "房间id")
    @TableId(value = "B_ID", type = IdType.AUTO)
    private Integer bId;

    @ApiModelProperty(value = "房间编号")
    @TableField("B_CODE")
    private Integer bCode;

    @ApiModelProperty(value = "房间面积（m^2）")
    @TableField("B_SIZE")
    private Integer bSize;

    @ApiModelProperty(value = "所属业主id")
    @TableField("B_OWNER_ID")
    private Integer bOwnerId;

    @ApiModelProperty(value = "现居住人姓名（若为出租填此项）")
    @TableField("B_LIVE_NAME")
    private String bLiveName;

    @ApiModelProperty(value = "现居人联系电话（若为出租填此项）")
    @TableField("B_LIVE_PHONE")
    private String bLivePhone;

    @ApiModelProperty(value = "居住人数")
    @TableField("B_NUN")
    private Integer bNun;

    @ApiModelProperty(value = "房间状态（0为未售出 1为业主正常居住 2为出租）")
    @TableField("B_STATE")
    private Integer bState;


}
