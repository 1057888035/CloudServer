package com.cloud.springcloud.Chargeservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.entity.Water;
import com.cloud.springcloud.Chargeservice.service.WaterService;
import com.cloud.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 用水信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/Chargeservice/water")
public class WaterController {


    @Autowired
    WaterService waterService;


    @GetMapping(value = "/getAll/{pn}",name = "查询用水信息")
    public CommonResult<Page<Water>> getall(@PathVariable("pn") int pn){
        Page<Water> page = new Page<>(pn,10);
        Page<Water> page1 = waterService.page(page);
        return new CommonResult<Page<Water>>(200,"success",page1);
    }

    @GetMapping(value = "/getforbuid/{buid}",name = "根据房间号查询用水信息")
    public CommonResult<Page<Water>> getForbuid(int buid){
        Page<Water> page = new Page<>(1,10);
        QueryWrapper<Water> wrapper = new QueryWrapper();
        wrapper.eq("W_BU_ID",buid);
        Page<Water> page1 = waterService.page(page, wrapper);
        return new CommonResult<Page<Water>>(200,"success",page1);
    }


    /**
     * 此接口不作为管理系统使用，系用户水表每月固定时间发送数据
     * @param water
     * @return
     */
    @GetMapping(value = "/save",name = "保存用水信息")
    public CommonResult getall(Water water){
        water.setWGmt(new Date());
        boolean save = waterService.save(water);
        if (save){
            return new CommonResult(200,"success",save);
        }else {
            return new CommonResult(400,"error");
        }
    }

    /**
     * 手动操作缴费
     * @param water
     * @return
     */
    @PostMapping(value = "/pay",name = "手动操作缴费")
    public CommonResult payForHuman(@RequestBody Water water){
        water.setWMoney(new BigDecimal(0));
        boolean update = waterService.updateById(water);
        if (update){
            return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"error");
        }
    }

}

