package com.cloud.springcloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Parking;
import com.cloud.springcloud.userservice.mapper.ParkingMapper;
import com.cloud.springcloud.userservice.service.ParkingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车位信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
@Service
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements ParkingService {

    @Autowired(required = false)
    ParkingMapper parkingMapper;

    @Override
    public CommonResult<Page<Parking>> getParking(Integer pn) {
        QueryWrapper<Parking> wrapper = new QueryWrapper();

        Page<Parking> page = new Page<>(pn,10);

        Page<Parking> mapIPage = parkingMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Parking>>(400,"没有数据");
        }
        return new CommonResult<Page<Parking>>(200,"success",mapIPage);
    }

    @Override
    public   CommonResult<Page<Parking>> getParkingById(Integer id) {
        QueryWrapper<Parking> wrapper = new QueryWrapper();
        wrapper.eq("P_ID",id);

        Page<Parking> page = new Page<>(1,10);

        Page<Parking> mapIPage = parkingMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Parking>>(400,"没有数据");
        }
        return new CommonResult<Page<Parking>>(200,"success",mapIPage);
    }

    @Override
    public   CommonResult<Page<Parking>> getParkingByNum(String num) {
        QueryWrapper<Parking> wrapper = new QueryWrapper();
        wrapper.eq("P_NUM",num);

        Page<Parking> page = new Page<>(1,10);

        Page<Parking> mapIPage = parkingMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Parking>>(400,"没有数据");
        }
        return new CommonResult<Page<Parking>>(200,"success",mapIPage);
    }
}
