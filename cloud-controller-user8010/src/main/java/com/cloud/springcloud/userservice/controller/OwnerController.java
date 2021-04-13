package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Owner;
import com.cloud.springcloud.userservice.mapper.OwnerMapper;
import com.cloud.springcloud.userservice.service.OwnerService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 业主信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
@RestController
@RequestMapping("/userservice/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;


    /**
     * 业主登录
     *
     * @param request
     * @param user
     * @param password
     * @return
     */
    @PostMapping(value = "/login", name = "业主登录")
    public CommonResult login(HttpServletRequest request, String user, String password) {
        Owner loginin = ownerService.loginin(user, password);
        if (loginin != null) {
            request.getSession().setAttribute("login", loginin);
            return new CommonResult(200, "登录成功");
        }
        return new CommonResult(400, "用户名或密码错误");

    }

    @GetMapping(value = "/save", name = "保存业主")
    public CommonResult save(Owner owner) {
        boolean b = ownerService.save(owner);
        if (b) {
            return new CommonResult(200, "success");
        } else {
            return new CommonResult(400, "false");
        }
    }

    @GetMapping(value = "/getAllOwner/{pn}", name = "查询所有业主")
    public CommonResult<Page<Owner>> getAllOwner(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        return ownerService.getOwner(pn);
    }

    @GetMapping(value = "/getOwnerForId/{id}", name = "根据id查询业主")
    public CommonResult<Page<Owner>> getOwnerForId(@PathVariable("id") Integer id) {
        return ownerService.getOwnerForId(id);
    }


    @GetMapping(value = "/getOwnerForPhone/{phone}", name = "根据手机号查询业主")
    public CommonResult<Page<Owner>> getOwnerForId(@PathVariable("phone") String phone) {
        return ownerService.getOwnerForPhone(phone);
    }


    @GetMapping(value = "/updateForId", name = "根据id修改业主")
    public CommonResult<Page<Owner>> updateForId(Owner owner) {
        return ownerService.updateForId(owner);
    }

    @GetMapping(value = "/deleteForId/{ids}", name = "根据id删除一个或多个业主信息")
    public CommonResult deleteForId(@PathVariable("ids") String ids) {

        if (ids.contains("-")) {
            //批量删除
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            /*组装id的集合*/
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            return ownerService.deleteForArryId(del_ids);

        } else {
            Integer id = Integer.parseInt(ids);
            return ownerService.deleteForId(id);
        }
    }

}
