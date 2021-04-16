package com.cloud.springcloud.userservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Instock;
import com.cloud.springcloud.userservice.entity.Parking;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 车位信息 服务类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
public interface ParkingService extends IService<Parking> {

    /**
     * 查询所有车位信息
     * @param pn
     * @return
     */
    CommonResult<Page<Parking>> getParking(Integer pn);

    /**
     * 根据车位号查询车位信息
     */
    CommonResult<Page<Parking>> getParkingById(Integer id);

    /**
     * 根据车牌号查车位信息
     */
    CommonResult<Page<Parking>> getParkingByNum(String num);


}
