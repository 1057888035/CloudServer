package com.cloud.springcloud.configservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.springcloud.configservice.entity.Rate;
import com.cloud.springcloud.configservice.service.RateService;
import com.cloud.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 收费费率信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/configservice/rate")
public class RateController {
       @Autowired
    RateService rateService;

       @GetMapping(value = "/getAll",name = "获取所有费率")
    public CommonResult<List<Rate>> getAllRate(){
           List<Rate> list = rateService.list();
           return new CommonResult<>(200,"success",list);
       }


    @GetMapping(value = "/getRateByName/{name}",name = "根据名称获取费率")
    public CommonResult<Rate> getRateByName(@PathVariable("name") String name){
        QueryWrapper<Rate> wrapper = new QueryWrapper();
        wrapper.eq("R_NAME",name);
        Rate one = rateService.getOne(wrapper);
        return new CommonResult<Rate>(200,"success",one);
    }

    @GetMapping(value = "/update",name = "修改费率")
    public CommonResult getRateByName(Rate rate){
        boolean b = rateService.updateById(rate);
        if (b){
        return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"error");
        }
    }

}

