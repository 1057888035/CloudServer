package com.cloud.springcloud.controller;

import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Application;
import com.cloud.springcloud.entities.entity.Complaint;
import com.cloud.springcloud.entities.entity.Dock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {

    public static final String SERVICE_URL = "http://CLOUD-CONTROLLER-SERVICE";

    @Autowired
    private RestTemplate template;


    /**
     * 查询所有申请
     * @param pn
     * @return
     */
    @GetMapping("/service/app/getAll/{pn}")
    public CommonResult getAllApp(@PathVariable("pn")Integer pn){
        return template.getForObject(SERVICE_URL+"/service/application/getAll/{pn}",CommonResult.class,pn);
    }


    /**
     * 获取空闲员工
     */
    @GetMapping("/charge/app/getStaff")
    public CommonResult getStaff(){
        return template.getForObject(SERVICE_URL+"/service/application/getStaff",CommonResult.class);
    }


    /**
     * 安排员工服务
     * @param application
     * @return
     */
    @GetMapping("/charge/app/arrgment")
    public CommonResult arrgment(Application application){
        return template.postForEntity(SERVICE_URL+"/service/application/arrgment",application,CommonResult.class).getBody();
    }







    @GetMapping("/charge/comp/getStaff/getAll/{pn}")
    public CommonResult getAllComp(@PathVariable("pn")Integer pn){
        return template.getForObject(SERVICE_URL+"/service/complaint/getAll/{pn}",CommonResult.class,pn);
    }


    @GetMapping("/charge/comp/setmsg")
    public CommonResult setmsg(Complaint complaint){
        return template.postForEntity(SERVICE_URL+"/service/complaint/setmsg",complaint,CommonResult.class).getBody();
    }


}
