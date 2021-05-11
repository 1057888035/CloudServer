package com.cloud.springcloud.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.JwtUtils;
import com.cloud.springcloud.entities.entity.Car;
import com.cloud.springcloud.entities.entity.Owner;
import com.cloud.springcloud.entities.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


@RestController
public class UserController {
    //public static final String PAYMENT_URL = "http://localhost:8010";
    public static final String USER_URL = "http://CLOUD-CONTROLLER-USER";

    @Autowired
    private RestTemplate template;

    @Autowired
    RedisTemplate redisTemplate;


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
     * 根据手机号查询业主
     */
    @GetMapping(value = "/getOwnerForPhone/{phone}", name = "根据手机号查询业主")
    public CommonResult<Page<Owner>> getOwnerForId(@PathVariable("phone") String phone) {
        return  template.getForObject(USER_URL+"/userservice/owner/getOwnerForPhone//"+phone,CommonResult.class);
    }


    /**
     * 保存员工
     * @param staff
     * @return
     */
    @GetMapping(value = "/user/staff/save")
    public CommonResult saveStaff(Staff staff,String date) throws Exception{
        date = date.replace("Z", " UTC");//是空格+UTC
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");//格式化的表达式
        Date d = format.parse(date );
        staff.setSBirthday(d);
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

    /**
     * 获取部门
     */
    @GetMapping(value = "/user/dp/getAllDp")
    public CommonResult getAllStaff(){
        return  template.getForObject(USER_URL+"/userservice/department/getAllDp",CommonResult.class);
    }

    /**
     * 跟新员工信息
     * @param staff
     * @return
     */
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


    /**
     * 员工登录
     * @param username
     * @param password
     * @return
     */
    @GetMapping(value ="/login/{username}/{password}")
    public CommonResult loginStaff(@PathVariable("username")String username,@PathVariable("password")String password){
        return  template.postForEntity(USER_URL+"/userservice/staff/login/"+username+"/"+password,"",CommonResult.class).getBody();
    }

    /**
     * 员工退出
     * @param username
     * @return
     */
    @GetMapping(value ="/loginout/{username}")
    public CommonResult loginStaff(@PathVariable("username")String username){
        return  template.postForEntity(USER_URL+"/userservice/staff/loginout/"+username,"",CommonResult.class).getBody();
    }

    @GetMapping(value = "/vue-admin-template/user/info", name = "员工信息")
    public CommonResult info(HttpServletRequest request, String token) {
        String userName = JwtUtils.getUserNameByToken(request);
        HashMap<Object, Object> map = new HashMap<>();
        if (  redisTemplate.opsForValue().get(userName) !=null){
            map.put("roles","[\""+userName+"\"]");
            map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            map.put("introduction","I am a super administrator");
            map.put("name",userName);
            return new CommonResult(200, "成功",map);
        }
        return new CommonResult(401,"未登录");
    }

    @GetMapping(value = "/getStaffForPhone/{phone}", name = "根据手机号查询员工")
    public CommonResult<Page<Staff>> getStaffForPhone(@PathVariable("phone") String phone) {
        return  template.getForObject(USER_URL+"/userservice/staff/getStaffForPhone/"+phone,CommonResult.class);

    }


}
