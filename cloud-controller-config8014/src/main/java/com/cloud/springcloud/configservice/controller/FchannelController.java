package com.cloud.springcloud.configservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.springcloud.entities.entity.Fchannel;
import com.cloud.springcloud.configservice.service.FchannelService;
import com.cloud.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 支付配置信息 前端控制器
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/configservice/fchannel")
public class FchannelController {
      @Autowired
    FchannelService fchannelService;

      @GetMapping(value = "/findbycode/{fcode}",name = "根据fcode查配置")
    public CommonResult<List<Fchannel>> findByCode(@PathVariable("fcode") String fcode){
          System.out.println(fcode);
          QueryWrapper<Fchannel> wrapper = new QueryWrapper();
          wrapper.eq("F_CODE",fcode);
          List<Fchannel> list = fchannelService.list(wrapper);
          return new CommonResult<List<Fchannel>>(200,"success",list);
      }

    @PostMapping(value = "/update",name = "更新fcode配置")
    public CommonResult<List<Fchannel>> update(@RequestBody Collection<Fchannel> entityList){
        boolean b = fchannelService.updateBatchById(entityList);
        return new CommonResult<List<Fchannel>>(200,"success");
    }



}

