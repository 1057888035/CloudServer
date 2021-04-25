package com.cloud.springcloud.userservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Instock;
import com.cloud.springcloud.userservice.service.InstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 房间信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/userservice/instock")
public class InstockController {

    @Autowired
    InstockService instockService;



    @GetMapping(value = "/getAll/{pn}",name = "获取所有物料信息")
    public CommonResult<Page<Instock>> getAll(@PathVariable("pn") int pn){
                return  instockService.getInstock(pn);
    }

    @GetMapping(value = "/getForName/{name}/{pn}",name = "根据名称获取所有物料信息")
    public CommonResult<Page<Instock>> getForName(@PathVariable(value = "name") String name, @PathVariable("pn") int pn){
        return  instockService.getBuildingForName(name,pn);
    }

    @GetMapping(value = "/update",name = "根据ID更新物料信息")
    public CommonResult updateById(Instock instock){
        return new CommonResult<>(200,"success", instockService.updateById(instock));
    }

    @PostMapping(value = "/save",name = "新增物料信息")
    public CommonResult save(@RequestBody Instock instock){
        return new CommonResult<>(200,"success", instockService.save(instock));
    }

    @GetMapping(value = "/deleteForId/{ids}" ,name = "根据id删除一个或多个物料信息")
    public CommonResult deleteForId(@PathVariable("ids")String ids){

        if (ids.contains("-")){
            //批量删除
            List<Integer> del_ids =new ArrayList<>();
            String[] str_ids = ids.split("-");
            /*组装id的集合*/
            for (String string :str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            return instockService.deleteForArryId(del_ids);

        }else {
            Integer id = Integer.parseInt(ids);
            return   instockService.deleteForId(id);
        }

    }

}

