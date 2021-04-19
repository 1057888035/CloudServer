package com.cloud.springcloud.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.service.entity.Application;
import com.cloud.springcloud.service.service.ApplicationService;
import com.cloud.springcloud.userservice.entity.Staff;
import com.cloud.springcloud.userservice.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户申请信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/service/application")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @Autowired
    StaffService staffService;


    /**
     * 客户端使用接口
     * @param application
     * @return
     */
    @GetMapping(value = "/save",name = "保存客户申请")
    public CommonResult save(Application application){
        boolean save = applicationService.save(application);
        if (save){
            return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"error");
        }
    }

    @GetMapping(value = "/getAll/{pn}" ,name = "查询所有申请并逆序")
    public CommonResult<Page<Application>> getAll(@PathVariable("pn")Integer pn){
        Page<Application> page = new Page<>(pn,10);
        QueryWrapper<Application> wrapper = new QueryWrapper();
        wrapper.orderByDesc("A_ID");
        Page<Application> page1 = applicationService.page(page, wrapper);
        return new CommonResult<Page<Application>>(200,"success",page1);
    }

    /**
     * 查询空闲员工
     */
    @GetMapping(value = "/getStaff" ,name = "查询空闲员工")
    public CommonResult get(){
        QueryWrapper<Staff> wrapper = new QueryWrapper();
        wrapper.eq("S_STATE",0);
        List<Staff> list = staffService.list(wrapper);
        return new CommonResult(200,"success",list);
    }


    @GetMapping(value = "/arrgment" ,name = "安排员工")
    public CommonResult getAll(Application application){
        QueryWrapper<Application> wrapper = new QueryWrapper();
        boolean updateById = applicationService.updateById(application);
        if (updateById){
        return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"error");
        }
    }








}

