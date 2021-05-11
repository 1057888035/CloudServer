package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Staff;
import com.cloud.springcloud.userservice.entity.Department;
import com.cloud.springcloud.userservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 部门信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/userservice/department")
public class DepartmentController {
        @Autowired
    DepartmentService departmentService;

    @GetMapping(value = "/getAllDp", name = "查询所有员工")
    public CommonResult<List<Department>> getAllDp() {
        List<Department> list = departmentService.list();
        if (list !=null){
           return new CommonResult<List<Department>>(200,"查询成功",list);
        }else {
           return new CommonResult<List<Department>>(400,"没有找到数据");
        }
    }

}

