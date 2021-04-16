package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Owner;
import com.cloud.springcloud.userservice.entity.Staff;
import com.cloud.springcloud.userservice.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 员工登录
     *
     * @param request
     * @param phone
     * @param password
     * @return
     */
    @PostMapping(value = "/login", name = "员工登录")
    public CommonResult login(HttpServletRequest request, String phone, String password) {
        Staff loginin = staffService.loginin(phone, password);
        if (loginin != null) {
            request.getSession().setAttribute("login", loginin);
            return new CommonResult(200, "登录成功");
        }
        return new CommonResult(400, "用户名或密码错误");

    }

    @GetMapping(value = "/save", name = "保存员工")
    public CommonResult save(Staff staff) {
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


    @GetMapping(value = "/updateForId", name = "根据id修改员工")
    public CommonResult<Page<Staff>> updateForId(Staff staff) {
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

