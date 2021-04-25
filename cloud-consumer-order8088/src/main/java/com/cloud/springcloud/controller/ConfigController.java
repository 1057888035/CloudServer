package com.cloud.springcloud.controller;

import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Adver;
import com.cloud.springcloud.entities.entity.Dock;
import com.cloud.springcloud.entities.entity.Fchannel;
import com.cloud.springcloud.entities.entity.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
public class ConfigController {

    public static final String CONFIG_URL = "http://CLOUD-CONTROLLER-CONFIG";

    @Autowired
    private RestTemplate template;


    /**
     * 获取广告
     * @param pn
     * @return
     */
    @GetMapping("/config/adver/getAll/{pn}")
    public CommonResult getAllDocke(@PathVariable("pn")Integer pn){
        return template.getForObject(CONFIG_URL+"/configservice/adver/getAll/{pn}",CommonResult.class,pn);
    }

    /**
     * 保存广告
     */
    @GetMapping("/config/adver/save")
    public CommonResult saveAdver(Adver adver){
        return template.postForEntity(CONFIG_URL+"/configservice/adver/save",adver,CommonResult.class).getBody();
    }

    /**
     * 修改广告
     * @param adver
     * @return
     */
    @GetMapping("/config/adver/update")
    public CommonResult updateAdver(Adver adver){
        return template.postForEntity(CONFIG_URL+"/configservice/adver/update",adver,CommonResult.class).getBody();
    }


    /**
     * 批量删除广告
     * @param ids
     * @return
     */
    @GetMapping("/config/adver/delete/{ids}")
    public CommonResult deleteAdver(@PathVariable("ids") String ids){
        return template.getForObject(CONFIG_URL+"/configservice/adver/delete/{ids}",CommonResult.class,ids);
}


    /**
     * 跟新支付配置
     * @param entityList
     * @return
     */
    @GetMapping("/config/fcha/update")
    public CommonResult updatef(Collection<Fchannel> entityList){
        return template.postForEntity(CONFIG_URL+"/configservice/fchannel/update",entityList,CommonResult.class).getBody();
    }

    /**
     * 根据fcode查询配置
     * @param fcode
     * @return
     */
    @GetMapping("/config/fcha/findbycode/{fcode}")
    public CommonResult findef(@PathVariable("fcode") String fcode){
        return template.getForObject(CONFIG_URL+"/configservice/fchannel/findbycode/{fcode}",CommonResult.class,fcode);
    }






    /**
     * 获取费率
     * @return
     */
    @GetMapping("/config/rate/getAllRate")
    public CommonResult getAllRate(){
        return template.getForObject(CONFIG_URL+"/configservice/rate/getAll",CommonResult.class);
    }

    /**
     * 跟新费率
     * @return
     */
    @GetMapping("/config/rate/update")
    public CommonResult updateRate(Rate rate){
        return template.postForEntity(CONFIG_URL+"/configservice/rate/update",rate,CommonResult.class).getBody();
    }



}
