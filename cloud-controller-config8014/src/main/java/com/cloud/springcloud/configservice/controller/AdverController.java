package com.cloud.springcloud.configservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.configservice.entity.Adver;
import com.cloud.springcloud.configservice.service.AdverService;
import com.cloud.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 广告信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/configservice/adver")
public class AdverController {

    @Autowired
    AdverService adverService;

    @GetMapping(value = "/getAll/{pn}",name = "获取所有广告(逆序)")
    public CommonResult<Page<Adver>> getallAdver(@PathVariable("pn")Integer pn){
        Page<Adver> page = new Page<>(pn,10);
        QueryWrapper<Adver> wrapper = new QueryWrapper();
        wrapper.orderByDesc("AD_ID");
        Page<Adver> page1 = adverService.page(page, wrapper);
        return new CommonResult<Page<Adver>>(200,"success",page1);
    }


    @GetMapping(value = "/save",name = "保存广告")
    public CommonResult saveAdver(Adver adver){
        boolean save = adverService.save(adver);
        if (save){
            return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"error");
        }

    }


    @GetMapping(value = "/delete/{ids}",name = "删除广告")
    public CommonResult saveAdver(String ids){
        if (ids.contains("-")){
            //批量删除
            List<Integer> del_ids =new ArrayList<>();
            String[] str_ids = ids.split("-");
            /*组装id的集合*/
            for (String string :str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            return new CommonResult(200,"success",adverService.removeByIds(del_ids));

        }else {
            Integer id = Integer.parseInt(ids);
            return new CommonResult(200,"success",adverService.removeById(Integer.parseInt(ids)));
        }

    }

    @GetMapping(value = "/update",name = "跟新广告")
    public CommonResult updateAdver(Adver adver){
        boolean b = adverService.updateById(adver);
        if (b){
            return new CommonResult(200,"success");
        }else {
            return new CommonResult(400,"error");
        }


    }


}

