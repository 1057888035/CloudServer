package com.cloud.springcloud.controller;

import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate template;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return template.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return  template.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
