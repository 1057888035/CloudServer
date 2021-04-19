package com.cloud.springcloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.cloud.springcloud.configservice.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ConfigMain8014 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain8014.class,args);
    }
}
