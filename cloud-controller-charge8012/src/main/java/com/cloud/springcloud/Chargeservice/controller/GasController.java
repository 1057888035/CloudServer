package com.cloud.springcloud.Chargeservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.Chargeservice.entity.Gas;
import com.cloud.springcloud.Chargeservice.service.GasService;
import com.cloud.springcloud.entities.CommonResult;
import io.swagger.models.Swagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用气信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/Chargeservice/gas")
public class GasController {

    @Autowired
    GasService gasService;

    /**
     * 查询用气信息
     */
    @GetMapping(value = "/getAll/{pn}",name = "查询用气信息")
    public CommonResult<Page<Gas>> getall(@PathVariable("pn") int pn){
        Page<Gas> page = new Page<>(pn,10);
        Page<Gas> page1 = gasService.page(page);
        return new CommonResult<Page<Gas>>(200,"success",page1);
    }

    @GetMapping(value = "/getforbuid/{buid}",name = "根据房间号查询用气信息")
    public CommonResult<Page<Gas>> getForbuid(int buid){
        Page<Gas> page = new Page<>(1,10);
        QueryWrapper<Gas> wrapper = new QueryWrapper();
        wrapper.eq("G_BU_ID",buid);
        Page<Gas> page1 = gasService.page(page, wrapper);
        return new CommonResult<Page<Gas>>(200,"success",page1);
    }


    /**
     * 此接口不作为管理系统使用，系用户气表每月固定时间发送数据
     * @param gas
     * @return
     */
    @GetMapping(value = "/save",name = "保存用气信息")
    public CommonResult getall(Gas gas){
        gas.setGGmt(new Date());
        boolean save = gasService.save(gas);
        if (save){
        return new CommonResult(200,"success",save);
        }else {
            return new CommonResult(400,"error");
        }
    }

    /**
     * 手动操作缴费
     * @param gas
     * @return
     */
    @GetMapping(value = "/pay",name = "手动操作缴费")
    public CommonResult payForHuman(Gas gas){
        gas.setGMoney(new BigDecimal(0));
        boolean update = gasService.updateById(gas);
        if (update){
            return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"error");
        }
    }





}

