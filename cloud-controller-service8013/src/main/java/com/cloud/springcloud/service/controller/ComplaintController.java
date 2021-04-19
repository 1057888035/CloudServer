package com.cloud.springcloud.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.service.entity.Application;
import com.cloud.springcloud.service.entity.Complaint;
import com.cloud.springcloud.service.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 客诉信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/service/complaint")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @GetMapping(value = "/getAll/{pn}" ,name = "查询所有申请并逆序")
    public CommonResult<Page<Complaint>> getAll(@PathVariable("pn")Integer pn){
        Page<Complaint> page = new Page<>(pn,10);
        QueryWrapper<Complaint> wrapper = new QueryWrapper();
        wrapper.orderByDesc("C_ID");
        Page<Complaint> page1 = complaintService.page(page, wrapper);
        return new CommonResult<Page<Complaint>>(200,"success",page1);
    }

    @GetMapping(value = "/setmsg" ,name = "客诉回复")
    public CommonResult getAll(Complaint complaint){
        boolean b = complaintService.updateById(complaint);
        if (b){
            return new CommonResult<Page<Complaint>>(200,"success");
        }else {
            return new CommonResult<Page<Complaint>>(200,"error");
        }
    }

}

