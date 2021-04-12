package com.cloud.springcloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Car;
import com.cloud.springcloud.userservice.mapper.CarMapper;
import com.cloud.springcloud.userservice.service.CarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {


    @Autowired(required = false)
    CarMapper carMapper;


    @Override
    public CommonResult<Page<Car>> getCar() {

        QueryWrapper<Car> wrapper = new QueryWrapper();
        wrapper.select();

        Page<Car> page = new Page<>(1,2);

        Page<Car> mapIPage = carMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Car>>(400,"没有数据");
        }
        return new CommonResult<Page<Car>>(200,"success",mapIPage);
    }

    @Override
    public CommonResult<List<Car>> getCarForNum(String cNum) {
        HashMap map = new HashMap<>();
        map.put("C_NUM",cNum);
        List<Car> byMap = carMapper.selectByMap(map);
        if (byMap ==null || byMap.isEmpty()){
            return new CommonResult<List<Car>>(400,"数据为空");
        }
            return new CommonResult<List<Car>>(200,"success",byMap);
    }

    @Override
    public CommonResult<List<Car>> getCarForName(String cName) {
        return null;
    }

    @Override
    public CommonResult<List<Car>> getCarForPhone(String phone) {
        return null;
    }

    @Override
    public boolean saveCar(Car car) {
        return false;
    }

    @Override
    public CommonResult deleteForId(int id) {
        return null;
    }

    @Override
    public CommonResult updateForId(Car car) {
        return null;
    }

    @Override
    public CommonResult deleteForArryId(List<Integer> id) {
        return null;
    }
}
