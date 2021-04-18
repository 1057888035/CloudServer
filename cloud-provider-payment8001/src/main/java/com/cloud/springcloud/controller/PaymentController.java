package com.cloud.springcloud.controller;

import com.cloud.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {



    @PostMapping(value = "/payment/create")
    public CommonResult create(){

        return null;
    }

}
