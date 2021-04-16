package com.cloud.springcloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Parking;
import com.cloud.springcloud.userservice.entity.Transfer;
import com.cloud.springcloud.userservice.mapper.TransferMapper;
import com.cloud.springcloud.userservice.service.TransferService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 调库申请信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-16
 */
@Service
public class TransferServiceImpl extends ServiceImpl<TransferMapper, Transfer> implements TransferService {

   @Autowired(required = false)
   TransferMapper transferMapper;

    @Override
    public CommonResult<IPage<Transfer>> getAll(Integer pn) {
        QueryWrapper<Transfer> wrapper = new QueryWrapper();

        Page<Transfer> page = new Page<>(pn,10);

        IPage<Transfer> mapIPage = transferMapper.selectPage(page, wrapper);

        if (mapIPage == null){
            return new CommonResult<IPage<Transfer>>(400,"没有数据");
        }
        return new CommonResult<IPage<Transfer>>(200,"success",mapIPage);
    }
}
