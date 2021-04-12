package com.cloud.springcloud.userservice.service.impl;

import com.cloud.springcloud.userservice.entity.Car;
import com.cloud.springcloud.userservice.mapper.CarMapper;
import com.cloud.springcloud.userservice.service.CarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
