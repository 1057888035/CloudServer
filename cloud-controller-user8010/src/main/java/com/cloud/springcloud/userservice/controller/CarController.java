package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Car;
import com.cloud.springcloud.userservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/getAllCar/{pn}" ,name = "查询所有登记车辆")
    public CommonResult<Page<Car>> getAllCar(@RequestParam(value = "pn" ,defaultValue = "1")Integer pn){
        return carService.getCar(pn);
    }

    @GetMapping(value = "/getCarForNum/{cnum}/{pn}" ,name = "根据车牌号查询登记车辆")
    public CommonResult<Page<Car>> getCarForNum(@PathVariable("cnum") String cNum, @RequestParam(value = "pn",defaultValue = "1")Integer pn){
        return carService.getCarForNum(cNum,pn);
    }

    @GetMapping(value = "/getCarForName/{cname}/{pn}" ,name = "根据用户姓名查询登记车辆")
    public CommonResult<Page<Car>> getCarForName(@PathVariable("cname") String cName, @RequestParam(value = "pn",defaultValue = "1")Integer pn){
        return carService.getCarForName(cName,pn);
    }

    @GetMapping(value = "/getCarForPhone/{phone}/{pn}" ,name = "根据手机号查询登记车辆")
    public CommonResult<Page<Car>> getCarForPhone(@PathVariable("cphone") String phone, @RequestParam(value = "pn",defaultValue = "1")Integer pn){
        return carService.getCarForPhone(phone,pn);
    }

}

