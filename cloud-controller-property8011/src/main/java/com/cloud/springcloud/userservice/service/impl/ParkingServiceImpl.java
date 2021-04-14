package com.cloud.springcloud.userservice.service.impl;

import com.cloud.springcloud.userservice.entity.Parking;
import com.cloud.springcloud.userservice.mapper.ParkingMapper;
import com.cloud.springcloud.userservice.service.ParkingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
