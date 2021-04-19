package com.cloud.springcloud.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.cloud.springcloud.entities.AlipayConfig;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.PayOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {



    @PostMapping(value = "/payment/create")
    public String create(PayOrder payOrder) throws Exception{

        AlipayConfig alipayConfig = new AlipayConfig();

        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.ServiceUrl,alipayConfig.app_id,alipayConfig.private_key,alipayConfig.format,alipayConfig.input_charset,alipayConfig.zfb_public_key,alipayConfig.signtype);

        AlipayTradeWapPayRequest request  = new AlipayTradeWapPayRequest();

        //封装参数

        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();

        model.setOutTradeNo(payOrder.getOut_trade_no());  //商品id
        model.setSubject(payOrder.getSubject());  //商品名称
        model.setTotalAmount(payOrder.getTotal_amount()); //支付金额
        model.setBody(payOrder.getBody());   //商品描述
        model.setTimeoutExpress(payOrder.getTimeout()); //请求超时时间
        model.setProductCode(payOrder.getProduct_code());  //商品code

        request.setBizModel(model);

        //设置异步回掉地址
        request.setNotifyUrl(alipayConfig.notify_url);
        //设置同步回调地址
        request.setReturnUrl(alipayConfig.return_url);

        String body = alipayClient.pageExecute(request).getBody();
        System.out.println(body);
        return body;
    }

}
