package com.cloud.springcloud.userservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Car;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 * 车辆信息 服务类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
public interface CarService extends IService<Car> {
      /**
       * 保存车辆信息
       * @param car 传入信息
       * @return  1保存成功 0 保存失败
       */
      boolean saveCar(Car car);

      /**
       * 获取所有车辆信息
       * @return
       */
      CommonResult<Page<Car>> getCar(Integer pn);

      /**
       * 根据车牌号获取车辆信息
       * @param cNum
       * @return
       */
      CommonResult<Page<Car>> getCarForNum(String cNum,Integer pn);

      /**
       * 根据业主名查询车辆信息
       * @param cName
       * @return   一个业主对应多个车辆
       */
      CommonResult<Page<Car>> getCarForName(String cName,Integer pn);

      /**
       * 根据手机号查询车辆信息
       * @param phone
       * @return   一个手机号对应多个车辆
       */
      CommonResult<Page<Car>> getCarForPhone(String phone,Integer pn);

      /**
       * 根据id更新车辆信息
       * @param car
       * @return
       */
      CommonResult updateForId(Car car);

      /**
       * 根据id删除车辆信息
       * @param id
       * @return
       */
      CommonResult deleteForId(int id);

      /**
       * 批量删除车辆信息
       * @param ids
       * @return
       */
      CommonResult deleteForArryId(List<Integer> ids);
}
