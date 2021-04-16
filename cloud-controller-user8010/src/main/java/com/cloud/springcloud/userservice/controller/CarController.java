package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.DateUtilss;
import com.cloud.springcloud.userservice.entity.Car;
import com.cloud.springcloud.userservice.service.CarService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping(value = "/savecar" ,name = "新增车辆信息")
    public CommonResult saveCar(Car car){
        boolean b = carService.saveCar(car);
        if (b){
          return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"false");
        }
    }

        @GetMapping(value = "/getAllCar/{pn}" ,name = "查询所有登记车辆")
    public CommonResult<Page<Car>> getAllCar(@PathVariable("pn")Integer pn){
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
    public CommonResult<Page<Car>> getCarForPhone(@PathVariable("phone") String phone, @RequestParam(value = "pn",defaultValue = "1")Integer pn){
        return carService.getCarForPhone(phone,pn);
    }

    @GetMapping(value = "/updateforid" ,name = "根据id跟新")
    public CommonResult updateForId(Car car){
        return carService.updateForId(car);
    }


    @GetMapping(value = "/deleteForId/{ids}" ,name = "根据id删除一个或多个车辆信息")
    public CommonResult deleteForId(@PathVariable("ids")String ids){

        if (ids.contains("-")){
            //批量删除
            List<Integer> del_ids =new ArrayList<>();
            String[] str_ids = ids.split("-");
            /*组装id的集合*/
            for (String string :str_ids){
                del_ids.add(Integer.parseInt(string));
            }
           return carService.deleteForArryId(del_ids);

        }else {
            Integer id = Integer.parseInt(ids);
          return   carService.deleteForId(id);
        }

    }


}

