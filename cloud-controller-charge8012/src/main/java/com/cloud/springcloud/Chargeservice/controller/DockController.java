package com.cloud.springcloud.Chargeservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.springcloud.Chargeservice.entity.Dock;
import com.cloud.springcloud.Chargeservice.entity.Gas;
import com.cloud.springcloud.Chargeservice.service.DockService;
import com.cloud.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.Date;

/**
 * <p>
 * 停车收费信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@RestController
@RequestMapping("/Chargeservice/dock")
public class DockController {


    @Autowired
    DockService dockService;

    /**
     *   dock.setDoState(0);设置缴费状态默认未缴费
     * @param dock
     * @return
     */
    @GetMapping(value = "/login",name = "车辆登入")
    public CommonResult save(Dock dock){
        dock.setDoState(0);
        dock.setGmtIn(new Date());
        boolean save = dockService.save(dock);
        if (save)
        {
            return new CommonResult(200,"登入成功",dock.getDoNum());
        }else {
            return new CommonResult(400,"登入失败",dock.getDoNum());
        }
    }

    /**
     * 该功能为用户在手机上操作
     * @param dock
     * @return
     */
    @GetMapping(value = "/updateForUser",name = "离开")
    public CommonResult updateforUser(Dock dock){
      return  dockService.loginout(dock);
    }


    /**
     * 手动操作缴费
     * @param dock
     * @return
     */
    @GetMapping(value = "/updateforRoot",name = "缴费")
    public CommonResult update(Dock dock){
        dock.setDoState(1);
        boolean b = dockService.updateById(dock);
        return new CommonResult(200,"success",b);
    }









}

