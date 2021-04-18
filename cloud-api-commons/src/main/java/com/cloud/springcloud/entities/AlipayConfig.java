package com.cloud.springcloud.entities;


public class AlipayConfig {
        //ServiceURL
        public static String ServiceUrl="https://openapi.alipay.com/gateway.do";
        //APP支付宝支付业务：app_id
        public static String app_id = "2021002140653256";
        // 商户的私钥,使用支付宝自带的openssl工具生成。
        public static String private_key = "xxxxxxxxxxxxxxxxxxx";
        // 应用的公钥，无需修改该值
        public static String ali_public_key  = "xxxxxxxxxxxxxxxxxxxxx";
        // 支付宝的公钥，去open.alipay.com对应应用下查看。
        public static String zfb_public_key  = "xxxxxxxxxxxxxxxxxxxxx";
        // 字符编码格式 目前支持 gbk 或 utf-8
        public static String input_charset = "UTF-8";
    }
