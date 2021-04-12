package com.cloud.springcloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Car;
import com.cloud.springcloud.userservice.mapper.CarMapper;
import com.cloud.springcloud.userservice.service.CarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    /**
     * 保存
     * integer 查询出车牌号是否存在
     * @param car 传入信息
     * @return
     */
    @Override
    public boolean saveCar(Car car) {
        car.setCRegist(new Date());
        QueryWrapper<Car> wrapper = new QueryWrapper();
        wrapper.eq("C_NUM",car.getCNum());
        Integer integer = carMapper.selectCount(wrapper);
        if (integer!=0) {return false;}
        int insert = carMapper.insert(car);
        if (insert==1) {return true;}else {return false;}
    }

    /**
     * 查询
     * @param pn
     * @return
     */
    @Override
    public CommonResult<Page<Car>> getCar(Integer pn) {

        QueryWrapper<Car> wrapper = new QueryWrapper();

        Page<Car> page = new Page<>(pn,10);

        Page<Car> mapIPage = carMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Car>>(400,"没有数据");
        }
        return new CommonResult<Page<Car>>(200,"success",mapIPage);
    }

    /**
     * 查询
     * @param pn
     * @return
     */
    @Override
    public CommonResult<Page<Car>> getCarForNum(String cNum,Integer pn) {
        QueryWrapper<Car> wrapper = new QueryWrapper();
        wrapper.eq("C_NUM",cNum);

        Page<Car> page = new Page<>(pn,10);

        Page<Car> mapIPage = carMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Car>>(400,"没有数据");
        }
        return new CommonResult<Page<Car>>(200,"success",mapIPage);
    }

    /**
     * 查询
     * @param pn
     * @return
     */
    @Override
    public CommonResult<Page<Car>> getCarForName(String cName, Integer pn) {
        QueryWrapper<Car> wrapper = new QueryWrapper();
        wrapper.eq("C_NAME",cName);

        Page<Car> page = new Page<>(pn,10);

        Page<Car> mapIPage = carMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Car>>(400,"没有数据");
        }
        return new CommonResult<Page<Car>>(200,"success",mapIPage);
    }

    /**
     * 查询
     * @param pn
     * @return
     */
    @Override
    public CommonResult<Page<Car>> getCarForPhone(String phone, Integer pn) {
        QueryWrapper<Car> wrapper = new QueryWrapper();
        wrapper.eq("C_PHONE",phone);

        Page<Car> page = new Page<>(pn,10);

        Page<Car> mapIPage = carMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Car>>(400,"没有数据");
        }
        return new CommonResult<Page<Car>>(200,"success",mapIPage);
    }

    /**
     * 根据id更新车辆信息
     * @param car
     * @return
     */
    @Override
    public CommonResult updateForId(Car car) {
        int i = carMapper.updateById(car);
        if (i != 1){
            return new CommonResult(400,"更新失败");
        }
        return new CommonResult(200,"更新成功");
    }

    /**
     * 根据id删除单个车辆信息
     * @param id
     * @return
     */
    @Override
    public CommonResult deleteForId(int id) {
        int i = carMapper.deleteById(id);
        if (i != 1){
            return new CommonResult<Page<Car>>(400,"删除失败");
        }
        return new CommonResult<Page<Car>>(200,"删除成功");
    }

    /**
     * 根据id删除多个车辆信息
     * @param ids
     * @return
     */
    @Override
    public CommonResult deleteForArryId(List<Integer> ids) {
        int i = carMapper.deleteBatchIds(ids);
        if (i == 0){
            return new CommonResult<Page<Car>>(400,"删除失败");
        }
        return new CommonResult<Page<Car>>(200,"删除成功");
    }


}
