package com.cloud.springcloud.controller;

import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Building;
import com.cloud.springcloud.entities.entity.Parking;
import com.cloud.springcloud.entities.entity.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class PropertyController {
    public static final String PROPERTY_URL = "http://CLOUD-CONTROLLER-PROPERTY";

    @Autowired
    private RestTemplate template;

    /**
     * 查询房间
     * @param pn
     * @return
     */
    @GetMapping("/pro/building/getBuilding/{pn}")
    public CommonResult getBuilding(@PathVariable("pn")Integer pn){
        return template.getForObject(PROPERTY_URL+"/userservice/building/getBuilding/{pn}",CommonResult.class,pn);
    }

    @PostMapping("/pro/building/import")
    public CommonResult importAlarmEvents(HttpServletRequest request,@RequestParam MultipartFile file){
        System.out.println(file.toString());
        return template.postForEntity(PROPERTY_URL+"/userservice/building/project/import",request,CommonResult.class,file).getBody();

    }

    /**
     * 新增房间
     * @param building
     * @return
     */
    @GetMapping("/pro/building/saveBuilding")
    public CommonResult saveBuilding(Building building){
        return template.postForEntity(PROPERTY_URL+"/userservice/building/saveBuilding",building,CommonResult.class).getBody();
    }

    /**
     * 更新房间
     * @param building
     * @return
     */
    @GetMapping("/pro/building/updateforid")
    public CommonResult updateBudforid(Building building){
        return template.postForEntity(PROPERTY_URL+"/userservice/building/updateforid",building,CommonResult.class).getBody();
    }

    /**
     * 根据code查
     * @param code
     * @return
     */
    @GetMapping("/pro/building/getBuildingForCode/{code}")
    public CommonResult getBuildingForCode(@PathVariable("code") Integer code){
        return template.getForObject(PROPERTY_URL+"/userservice/building/getBuildingForCode/{code}",CommonResult.class,code);
    }



    /**
     * 删除房间信息
     * @param ids
     * @return
     */
    @GetMapping("/pro/building/deleteForId/{ids}")
    public CommonResult deleteBudForId(@PathVariable("ids")String ids){
        return template.getForObject(PROPERTY_URL+"/deleteForId/{ids}",CommonResult.class,ids);
    }





    /**
     * 物料
     */




    /**
     * 查询所有物料
     * @param pn
     * @return
     */
    @GetMapping("/pro/instock//getAll/{pn}")
    public CommonResult getAllIns(@PathVariable("pn")Integer pn){
        return template.getForObject(PROPERTY_URL+"/userservice/instock/getAll/{pn}",CommonResult.class,pn);
    }

    /**
     * 新增物料
     * @param building
     * @return
     */
    @GetMapping("/pro/instock/save")
    public CommonResult saveIns(Building building){
        return template.postForEntity(PROPERTY_URL+"/userservice/instock/save",building,CommonResult.class).getBody();
    }


    /**
     * 删除物料信息
     * @param ids
     * @return
     */
    @GetMapping("/pro/instock/deleteForId/{ids}")
    public CommonResult deleteInsForId(@PathVariable("ids")String ids){
        return template.getForObject(PROPERTY_URL+"/userservice/instock/deleteForId/{ids}",CommonResult.class,ids);
    }


    /**
     * 获取车位信息信息
     * @param pn
     * @return
     */
    @GetMapping("/pro/parking/getAll/{pn}")
    public CommonResult getParking(@PathVariable("pn") Integer pn){
        return template.getForObject(PROPERTY_URL+"/userservice/parking/getAll/{pn}",CommonResult.class,pn);
    }


    /**
     * 更新车位信息信息
     * @param parking
     * @return
     */
    @GetMapping("/pro/parking/updateById")
    public CommonResult getParking(Parking parking){
        return template.postForEntity(PROPERTY_URL+"/userservice/parking/updateById",parking,CommonResult.class).getBody();
    }


    /**
     * 调库申请
     * @param pn
     * @return
     */
    @GetMapping("/pro/trans/getAll/{pn}")
    public CommonResult getTrans(@PathVariable("pn") Integer pn){
        return template.getForObject(PROPERTY_URL+"/userservice/transfer/getAll/{pn}",CommonResult.class,pn);
    }


    @GetMapping("/pro/trans/update")
    public CommonResult getTrans(Transfer transfer){
        return template.postForEntity(PROPERTY_URL+"/userservice/transfer/update",transfer,CommonResult.class).getBody();
    }


}
