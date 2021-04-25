package com.cloud.springcloud.controller;

import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChageController {
    public static final String CHARGE_URL = "http://CLOUD-CONTROLLER-CHARGE";

    @Autowired
    private RestTemplate template;


    /**
     * 停车收费信息
     * @param pn
     * @return
     */

    @GetMapping("/charge/dock/getAllDocke/{pn}")
    public CommonResult getAllDocke(@PathVariable("pn")Integer pn){
        return template.getForObject(CHARGE_URL+"/Chargeservice/dock/getAllDocke/{pn}",CommonResult.class,pn);
    }

    /**
     * 手动缴费功能
     */
    @GetMapping("/charge/dock/updateforRoot")
    public CommonResult updateforRoot(Dock dock){
        return template.postForEntity(CHARGE_URL+"/Chargeservice/dock/updateforRoot",dock,CommonResult.class).getBody();
    }


    /**
     *
     * 用气信息管理
     * @param pn
     * @return
     */

    @GetMapping("/charge/gas/getAll/{pn}")
    public CommonResult getAllGas(@PathVariable("pn")Integer pn){
        return template.getForObject(CHARGE_URL+"/Chargeservice/gas/getAll/{pn}",CommonResult.class,pn);
    }

    /**
     * 手动缴费
     * @param gas
     * @return
     */
    @GetMapping("/charge/gas/updateforRoot")
    public CommonResult updategasforRoot(Gas gas){
        return template.postForEntity(CHARGE_URL+"/Chargeservice/gas/pay",gas,CommonResult.class).getBody();
    }




    /**
     *
     * 用电信息管理
     * @param pn
     * @return
     */

    @GetMapping("/charge/power/getAll/{pn}")
    public CommonResult getAllPower(@PathVariable("pn")Integer pn){
        return template.getForObject(CHARGE_URL+"/Chargeservice/power/getAll/{pn}",CommonResult.class,pn);
    }

    /**
     * 手动缴费
     * @param power
     * @return
     */
    @GetMapping("/charge/power/payForHuman")
    public CommonResult payForHuman(Power power){
        return template.postForEntity(CHARGE_URL+"/Chargeservice/power/pay",power,CommonResult.class).getBody();
    }






    /**
     *
     * 物业费管理
     * @param pn
     * @return
     */

    @GetMapping("/charge/pro/getAll/{pn}")
    public CommonResult getAllProperty(@PathVariable("pn")Integer pn){
        return template.getForObject(CHARGE_URL+"/Chargeservice/property/getAll/{pn}",CommonResult.class,pn);
    }

    /**
     * 手动缴费
     * @param property
     * @return
     */
    @GetMapping("/charge/pro/save")
    public CommonResult savePro(Property property){
        return template.postForEntity(CHARGE_URL+"/Chargeservice/property/save",property,CommonResult.class).getBody();
    }





















    @GetMapping("/charge/water/getAll/{pn}")
    public CommonResult getAllWater(@PathVariable("pn")Integer pn){
        return template.getForObject(CHARGE_URL+"/Chargeservice/water/getAll/{pn}",CommonResult.class,pn);
    }

    /**
     * 手动缴费
     * @param water
     * @return
     */
    @GetMapping("/charge/water/pay")
    public CommonResult saveWater(Water water){
        return template.postForEntity(CHARGE_URL+"/Chargeservice/water/pay",water,CommonResult.class).getBody();
    }


}
