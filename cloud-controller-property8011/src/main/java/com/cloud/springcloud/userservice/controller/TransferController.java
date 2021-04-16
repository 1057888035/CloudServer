package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Parking;
import com.cloud.springcloud.userservice.entity.Transfer;
import com.cloud.springcloud.userservice.service.TransferService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 调库申请信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-16
 */
@RestController
@RequestMapping("/userservice/transfer")
public class TransferController {

    @Autowired
    TransferService transferService;

    @GetMapping(value = "/save" ,name = "提交调库申请")
    public CommonResult savetransfer(Transfer transfer){
        return new CommonResult(200,"success",transferService.save(transfer));
    }

    @GetMapping(value = "/update" ,name = "审核调库申请")
    public CommonResult updatetransfer(Transfer transfer){
        return new CommonResult(200,"success",transferService.updateById(transfer));
    }

    @GetMapping(value = "/getAll/{pn}" ,name = "审核调库申请")
    public CommonResult<Page<Transfer>> getAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        Page<Transfer> page = new Page<>(pn,10);
       return  transferService.getAll(pn);
    }
}

