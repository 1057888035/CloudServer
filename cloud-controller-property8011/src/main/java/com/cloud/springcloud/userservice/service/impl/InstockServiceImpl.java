package com.cloud.springcloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Instock;
import com.cloud.springcloud.userservice.mapper.InstockMapper;
import com.cloud.springcloud.userservice.service.InstockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *
 * 物料管理服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
@Service
public class InstockServiceImpl extends ServiceImpl<InstockMapper, Instock> implements InstockService {

    @Autowired(required = false)
    InstockMapper instockMapper;

    @Override
    public CommonResult<Page<Instock>> getInstock(Integer pn) {
        QueryWrapper<Instock> wrapper = new QueryWrapper();

        Page<Instock> page = new Page<>(pn,10);

        Page<Instock> mapIPage = instockMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Instock>>(400,"没有数据");
        }
        return new CommonResult<Page<Instock>>(200,"success",mapIPage);
    }

    @Override
    public CommonResult<Page<Instock>> getBuildingForName(String name,int pn) {
        QueryWrapper<Instock> wrapper = new QueryWrapper();
        wrapper.eq("I_NAME",name);

        Page<Instock> page = new Page<>(pn,10);

        Page<Instock> mapIPage = instockMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Instock>>(400,"没有数据");
        }
        return new CommonResult<Page<Instock>>(200,"success",mapIPage);
    }


    @Override
    public CommonResult deleteForId(int id) {
        int i = instockMapper.deleteById(id);
        if (i != 1){
            return new CommonResult(400,"删除失败");
        }
        return new CommonResult(200,"删除成功");
    }

    @Override
    public CommonResult deleteForArryId(List<Integer> ids) {
        int i = instockMapper.deleteBatchIds(ids);
        if (i == 0){
            return new CommonResult(400,"删除失败");
        }
        return new CommonResult(200,"删除成功");
    }

}
