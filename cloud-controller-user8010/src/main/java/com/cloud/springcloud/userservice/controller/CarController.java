package com.cloud.springcloud.userservice.controller;


import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Car;
import com.cloud.springcloud.userservice.mapper.CarMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 车辆信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
@RestController
@RequestMapping("/userservice/car")
public class CarController {

    @Resource
    CarMapper carMapper;


    @GetMapping(value = "/getAllCar" ,name = "查询所有登记车辆")
    public CommonResult getAllCar(String username,String password){
        List<Car> cars= carMapper.selectList(null);
        if (cars == null || cars.isEmpty()){
            return new CommonResult(400,"没有数据");
        }
        return new CommonResult(200,"success",cars);
    }
}

