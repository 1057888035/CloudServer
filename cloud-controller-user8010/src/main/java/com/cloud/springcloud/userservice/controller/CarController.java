package com.cloud.springcloud.userservice.controller;


import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Car;
import com.cloud.springcloud.userservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    CarService carService;

    @GetMapping(value = "/getAllCar" ,name = "查询所有登记车辆")
    public CommonResult<List<Car>> getAllCar(){
        return carService.getCar();

    }

    @GetMapping(value = "/getAllCar/{cnum}" ,name = "根据车牌号查询登记车辆")
    public CommonResult<List<Car>> getCarForNum(@PathVariable("cnum") String cNum ){
        return carService.getCarForNum(cNum);

    }

}

