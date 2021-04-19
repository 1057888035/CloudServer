package com.cloud.springcloud.entities;

import lombok.Data;


public  class AlipayConfig {
        //ServiceURL
        public static String ServiceUrl="https://openapi.alipaydev.com/gateway.do";
        //APP支付宝支付业务：app_id
        public static String app_id = "2021000117640642";
        // 商户的私钥,使用支付宝自带的openssl工具生成。
        public static String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCAh4eJUbBgb+AX4on5HODxscb5OUWlniForvT1++Ep4W7zvWSOv7J/BHhxnCgCKj8ZeYtANdgtIWwyLxqvMeKpyyydDsbEZT8U/iBSt0h147ahjrzJ4QAjVoutZmIhipa52ZwJ1jRZM17aG86mOBu0XfMbjNNUiX7Ffv0qfxmRzNmSocw4kK5owaBubwK6L71C6g67Jn5kGCvMu23KJllyUoaxINdoyJXSmbSJvrDaSnXXSpaXe2Hh8q/RB2Ty7cQFmNE/6h7B/5PeuOBYtEX4mfSeK9u2/N2HPQVKUnBXxUf4y/gTMTPEJJSjGYf4WlG+egyQdCda9AHiTZL9ts27AgMBAAECggEAQqyLvctXkJ9Yg2tsIYM+mYKccjqoi4KdWB2yS0yPgFdGZEByQq7k3IkoJd9Yzc62jvODLhsAemDlLJ9M22coauZPzWWV7NmMwMoXYHFdsHIhEmvmOV9z3+EMcjYzX6zyBZUCIgQxgbhpUwGr0IQ4svctnrQOCMOOtMrsb7ghPoVmZoZ6JfIxgFS8sAecjr6/sdDVF71DaNKdYvsaJjDYo6xkc9eg3DD2nUtHM1+WXWqo1Zzcv8FAb2vlJX3FFTBAMgEq0YctiZd5VZQ3VXAP2n1+m6/Wn/i4m5t+TqBuXYHqVEqc2pgfyHLl1yuwXgOKLyF2Di0y83zz/kA5a/nikQKBgQC7olafrLArGnrfoLzFFFncS79xanP5rf3TmYnNzYry238SKDIFxHLGRGcBQzFCbnxcaKlD7NcUAaeEK1/DX5cIGladVWFKZ6+bsXNp0zqquUgTwV5GHN705m7WMSXiThigb5bdv66zuI2yrlDiQ7Y2dYtvrnLX9npYkKeJX3hMaQKBgQCvXCuiCuJcqE/L70khr5mDrbyZzUmMSyFmDQM/COlFQdOFpDa34/NbQk+NRDJ4UMtk52/9nBYPRBowy3TYEECyuvkYOQsIFB/cP1Tz97AwlGRbP1p0Z0GPKxoeL1RZ8fe3KMkFxms8p4CEIYQW5Hca+JqZLkZ86/MWeS/368OUgwKBgQCFeK47+WB72ONNDo8ZdieR8IQnTn1fP6iOi+qd7jeIGCFlLhifR6YJaYEIQd7ZjbSDG6REgEZioeaiuyPs26OZDPtOAf0qK2Wcz/b0cWCLLy+ZdfT01Pa4qO5xCRcUy07zWU2tQfwpNf/9+cfpnBcS2Dyu3h4th9RyCbxTmQj++QKBgDoweJ4dxH2AsHH4pijSbzt9xE65C0XNjHijqscY+ucrb7gyBKJCtvc6atFypti73rJOBiB+0ecg7xvv94bW5dEpMA00qI92thfMwDDwqPuF0kNhI2/q75tFbzZC+FecblnN497Rt7X50zCFOqKqD0fY5NwdufAsD48OibdX+Z9nAoGAazxECsz+tF2EGbe2M6tEyYkJZ2kRz4GhyTfOW0G2irNHy+nGbxJnJ8pO22YgqNt94Q3+RHkKzSUe73mRhbMmxavKmE8CCxCMd6uy9ljdicjN5jrhE6Tv8deTvncnaeXPJqp1BIcMPSGRFa+hpYkVEqskvZ9J33BeuBThwI4XH+c=";
        // 应用的公钥，无需修改该值
        public static String ali_public_key  = "xxxxxxxxxxxxxxxxxxxxx";
        // 支付宝的公钥，去open.alipay.com对应应用下查看。
        public static String zfb_public_key  = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlJZFn2QcaHkKfAa1wfK7O8o/dZyM0PDLkXf5m4tp4gPvRr4HdoV/h3yyYad8SRA5kAXsIaaOqSjmW0QHIpvtkK13YMw5/MtYlxwkCpAg/wRDitx6pDLgJycJdSXl4IXnS4xam00iEWslx3AOKMXvTGw12hoIp+YLsttIdB46YFvlN+4qZZLjnVarbwmKV1u4fROsAaHXeXPVo9IOsSCGzcZvr0mqjUew10oKc8n+gKaSwsZwpFwUU7PoidMLPJHek/7BOXjritmDNBS1e5DOV9nvv0JFBxmoI8seHD0AYVnSQBlY8Seh3KJzZK2QAyj8SZ5bcL1f98lrMrxWsMea2wIDAQAB";
        // 字符编码格式 目前支持 gbk 或 utf-8
        public static String input_charset = "UTF-8";
        //返回格式
        public static  String format = "json";
        //支付宝公钥
        public static String signtype="RSA2";
        //回调地址
        public static String notify_url="www.baidu.com";

        public static String return_url="www.baidu.com";

    }
