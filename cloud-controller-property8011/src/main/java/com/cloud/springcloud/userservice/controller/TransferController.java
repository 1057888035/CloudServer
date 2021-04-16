package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Parking;
import com.cloud.springcloud.userservice.entity.Transfer;
import com.cloud.springcloud.userservice.service.TransferService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/getAll/{pn}" ,name = "查看调库申请")
    public CommonResult<IPage<Transfer>> getAll(@PathVariable("pn") Integer pn){
        Page<Transfer> page = new Page<>(pn,10);
       return  transferService.getAll(pn);
    }
}

