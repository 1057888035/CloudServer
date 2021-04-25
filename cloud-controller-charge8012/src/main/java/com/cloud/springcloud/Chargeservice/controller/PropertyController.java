package com.cloud.springcloud.Chargeservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.entity.Property;
import com.cloud.springcloud.Chargeservice.service.PropertyService;
import com.cloud.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 * 物业费用信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/Chargeservice/property")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    /**
     * 查询用气信息
     */
    @GetMapping(value = "/getAll/{pn}",name = "查询物业费用信息")
    public CommonResult<Page<Property>> getall(@PathVariable("pn") int pn){
        Page<Property> page = new Page<>(pn,10);
        Page<Property> page1 = propertyService.page(page);
        return new CommonResult<Page<Property>>(200,"success",page1);
    }

    @GetMapping(value = "/getforbuid/{buid}",name = "根据房间号查询物业费用信息")
    public CommonResult<Page<Property>> getForbuid(int buid){
        Page<Property> page = new Page<>(1,10);
        QueryWrapper<Property> wrapper = new QueryWrapper();
        wrapper.eq("BU_ID",buid);
        Page<Property> page1 = propertyService.page(page, wrapper);
        return new CommonResult<Page<Property>>(200,"success",page1);
    }


    /**
     * 此接口不作为管理系统使用，系用户每月固定时间生成数据
     * @param property
     * @return
     */
    @GetMapping(value = "/savepro",name = "保存物业费用信息")
    public CommonResult savePro(Property property){
        property.setPrGmt(new Date());
        boolean save = propertyService.save(property);
        if (save){
            return new CommonResult(200,"success",save);
        }else {
            return new CommonResult(400,"error");
        }
    }

    /**
     * 手动操作缴费
     * @param property
     * @return
     */
    @PostMapping(value = "/save",name = "手动操作缴费")
    public CommonResult payForHuman(@RequestBody Property property){
        property.setPrState(1);
        boolean update = propertyService.updateById(property);
        if (update){
            return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"error");
        }
    }
}

