package com.cloud.springcloud.Chargeservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.entity.Power;
import com.cloud.springcloud.Chargeservice.service.PowerService;
import com.cloud.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 用电信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/Chargeservice/power")
public class PowerController {

    @Autowired
    PowerService powerService;

    /**
     * 查询用气信息
     */
    @GetMapping(value = "/getAll/{pn}",name = "查询用电信息")
    public CommonResult<Page<Power>> getall(@PathVariable("pn") int pn){
        Page<Power> page = new Page<>(pn,10);
        Page<Power> page1 = powerService.page(page);
        return new CommonResult<Page<Power>>(200,"success",page1);
    }

    @GetMapping(value = "/getforbuid/{buid}",name = "根据房间号查询用电信息")
    public CommonResult<Page<Power>> getForbuid(int buid){
        Page<Power> page = new Page<>(1,10);
        QueryWrapper<Power> wrapper = new QueryWrapper();
        wrapper.eq("PW_BU_ID",buid);
        Page<Power> page1 = powerService.page(page, wrapper);
        return new CommonResult<Page<Power>>(200,"success",page1);
    }


    /**
     * 此接口不作为管理系统使用，系用户气表每月固定时间发送数据
     * @param power
     * @return
     */
    @GetMapping(value = "/save",name = "保存用电信息")
    public CommonResult getall(Power power){
        power.setPwGmt(new Date());
        boolean save = powerService.save(power);
        if (save){
            return new CommonResult(200,"success",save);
        }else {
            return new CommonResult(400,"error");
        }
    }

    /**
     * 手动操作缴费
     * @param power
     * @return
     */
    @GetMapping(value = "/pay",name = "手动操作缴费")
    public CommonResult payForHuman(Power power){
        power.setPwMoney(new BigDecimal(0));
        boolean update = powerService.updateById(power);
        if (update){
            return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"error");
        }
    }
}

