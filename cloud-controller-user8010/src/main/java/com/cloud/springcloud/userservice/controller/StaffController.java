package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.HashScripty;
import com.cloud.springcloud.entities.JwtUtils;
import com.cloud.springcloud.entities.entity.Staff;
import com.cloud.springcloud.userservice.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 员工信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
@RestController
@RequestMapping("/userservice/staff")
public class StaffController {

    @Autowired(required = false)
    StaffService staffService;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 员工登录
     * @return
     */
    @PostMapping(value = "/login/{username}/{password}", name = "员工登录")
    public CommonResult login(@PathVariable("username")String username,@PathVariable("password")String password) {
        HashMap<Object, Object> hashStaff = new HashMap<>();
        //对密码进行hash256加密
        password=HashScripty.SHA256(password);
        Staff loginin = staffService.loginin(username, password);
        if (loginin != null &&loginin.getSType()==0) {
            String token = JwtUtils.sign(username,password);
            hashStaff.put("X-Token",token);
            //将token存储到redis里
            redisTemplate.opsForValue().set(username,token,30, TimeUnit.MINUTES);
            System.out.println(redisTemplate.opsForValue().get(username));
            return new CommonResult(200, "登录成功",hashStaff);
        }
        return new CommonResult(400, "用户名或密码错误");

    }



    @PostMapping(value = "/loginout/{username}", name = "员工登出")
    public CommonResult loginout(@PathVariable("username")String username) {
            redisTemplate.delete(username);
        System.out.println(redisTemplate.opsForValue().get(username));
            return new CommonResult(200, "成功");
    }



    @PostMapping(value = "/save", name = "保存员工")
    public CommonResult save(@RequestBody Staff staff) {
        staff.setSPassword(HashScripty.SHA256(staff.getSPassword()));
        boolean b = staffService.save(staff);
        if (b) {
            return new CommonResult(200, "success");
        } else {
            return new CommonResult(400, "false");
        }
    }

    @GetMapping(value = "/getAllStaff/{pn}", name = "查询所有员工")
    public CommonResult<Page<Staff>> getAllStaff(@PathVariable("pn") Integer pn) {
        return staffService.getStaff(pn);
    }

    @GetMapping(value = "/getStaffForName/{name}", name = "根据name查询员工")
    public CommonResult<Page<Staff>> getStaffForName(@PathVariable("name") String name) {
        return staffService.getStaffForname(name);
    }


    @GetMapping(value = "/getStaffForPhone/{phone}", name = "根据手机号查询员工")
    public CommonResult<Page<Staff>> getStaffForPhone(@PathVariable("phone") String phone) {
        return staffService.getStaffForPhone(phone);
    }


    @PostMapping(value = "/updateForId", name = "根据id修改员工")
    public CommonResult<Page<Staff>> updateForId(@RequestBody Staff staff) {
        return staffService.updateForId(staff);
    }

    @GetMapping(value = "/deleteForId/{ids}", name = "根据id删除一个或多个员工信息")
    public CommonResult deleteForId(@PathVariable("ids") String ids) {

        if (ids.contains("-")) {
            //批量删除
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            /*组装id的集合*/
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            return staffService.deleteForArryId(del_ids);

        } else {
            Integer id = Integer.parseInt(ids);
            return staffService.deleteForId(id);
        }
    }
}

