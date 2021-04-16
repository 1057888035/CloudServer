package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Parking;
import com.cloud.springcloud.userservice.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 车位信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/userservice/parking")
public class ParkingController {

    @Autowired
    ParkingService parkingService;

    @GetMapping(value = "/getAll/{pn}" ,name = "获取所有车位信息")
    public CommonResult<Page<Parking>> getAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        return parkingService.getParking(pn);
    }

    @GetMapping(value = "/getParkingById/{id}" ,name = "获取所有车位信息")
    public CommonResult<Page<Parking>> getParkingById(@PathVariable("id") Integer id){
        return parkingService.getParkingById(id);
    }

    @GetMapping(value = "/getParkingByNum/{num}" ,name = "获取所有车位信息")
    public CommonResult<Page<Parking>> getParkingByNum(@PathVariable("num") String num){
        return parkingService.getParkingByNum(num);
    }

    @GetMapping(value = "/updateById" ,name = "获取所有车位信息")
    public CommonResult getParkingByNum(Parking parking){
        return new CommonResult(200,"success",parkingService.updateById(parking));
    }
}

