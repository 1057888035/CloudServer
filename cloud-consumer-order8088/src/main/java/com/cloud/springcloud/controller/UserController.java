package com.cloud.springcloud.controller;

import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Car;
import com.cloud.springcloud.entities.entity.Owner;
import com.cloud.springcloud.entities.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class UserController {
    //public static final String PAYMENT_URL = "http://localhost:8010";
    public static final String USER_URL = "http://CLOUD-CONTROLLER-USER";

    @Autowired
    private RestTemplate template;


    /**
     * 车辆管理
     * @param cNum
     * @param cName
     * @param cPhone
     * @return
     */
    @GetMapping(value = "/user/car/savecar/{cNum}/{cName}/{cPhone}")
    public CommonResult create(@PathVariable("cNum")String cNum, @PathVariable("cName")String cName, @PathVariable("cPhone")String cPhone){
        return  template.getForObject(USER_URL+"/userservice/car/savecar/{cNum}/{cName}/{cPhone}",CommonResult.class,cNum,cName,cPhone);
    }

    @GetMapping(value = "/user/car/updateforid")
    public CommonResult updateCar(Car car){
        return  template.postForEntity(USER_URL+"/userservice/car/updateforid",car,CommonResult.class).getBody();
    }
    @GetMapping(value = "/user/car/deleteForId/{ids}")
    public CommonResult deleteCarForId(@PathVariable("ids")String ids){
        return  template.getForObject(USER_URL+"/userservice/car/deleteForId/{ids}",CommonResult.class,ids);
    }





    /**
     * 业主管理
     */

    /**
     * 保存业主
     * @param owner
     * @return
     */
    @GetMapping(value = "/user/owner/save")
    public CommonResult saveOwner(Owner owner){
        return  template.postForEntity(USER_URL+"/userservice/owner/save",owner,CommonResult.class).getBody();
    }

    /**
     * 查询所有业主
     */
    @GetMapping(value = "/user/owner/getAllOwner/{pn}")
    public CommonResult getAllOwner(@PathVariable("pn") Integer pn){
        return  template.getForObject(USER_URL+"/userservice/owner/getAllOwner/{pn}",CommonResult.class,pn);
    }
    /**
     * 修改业主
     */
    @GetMapping(value = "/user/owner/updateForId")
    public CommonResult updateOwnerForId(Owner owner){
        return  template.postForEntity(USER_URL+"/userservice/owner/updateForId",owner,CommonResult.class).getBody();
    }

    /**
     * 删除业主
     * @param ids
     * @return
     */
    @GetMapping(value = "/user/owner/deleteForId/{ids}")
    public CommonResult deleteOwnerForId(@PathVariable("ids") String ids){
        return  template.getForObject(USER_URL+"/userservice/owner/deleteForId/{ids}",CommonResult.class,ids);
    }


    /**
     * 保存员工
     * @param staff
     * @return
     */
    @GetMapping(value = "/user/staff/save")
    public CommonResult saveStaff(Staff staff){
        return  template.postForEntity(USER_URL+"/userservice/staff/save",staff,CommonResult.class).getBody();
    }


    /**
     * 获取员工
     * @param pn
     * @return
     */
    @GetMapping(value = "/user/staff/getAllStaff/{pn}")
    public CommonResult getAllStaff(@PathVariable("pn") Integer pn){
        return  template.getForObject(USER_URL+"/userservice/staff/getAllStaff/{pn}",CommonResult.class,pn);
    }

    @GetMapping(value = "/user/staff/updateForId")
    public CommonResult updateStaffForId(Staff staff){
        return  template.postForEntity(USER_URL+"/userservice/staff/updateForId",staff,CommonResult.class).getBody();
    }

    /**
     * 删除员工
     * @param ids
     * @return
     */
    @GetMapping(value = "/user/staff/deleteForId/{ids}")
    public CommonResult deleteStaffForId(@PathVariable("ids") String ids){
        return  template.getForObject(USER_URL+"/userservice/staff/deleteForId/{ids}",CommonResult.class,ids);
    }



    @GetMapping(value ="/login/{username}/{password}")
    public CommonResult loginStaff(@PathVariable("username")String username,@PathVariable("password")String password){
        return  template.postForEntity(USER_URL+"/userservice/staff/login/"+username+"/"+password,"",CommonResult.class).getBody();
    }




}
