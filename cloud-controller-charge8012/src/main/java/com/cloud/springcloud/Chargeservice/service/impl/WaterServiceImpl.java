package com.cloud.springcloud.Chargeservice.service.impl;

import com.cloud.springcloud.entities.entity.Water;
import com.cloud.springcloud.Chargeservice.mapper.WaterMapper;
import com.cloud.springcloud.Chargeservice.service.WaterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用水信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@Service
public class WaterServiceImpl extends ServiceImpl<WaterMapper, Water> implements WaterService {

}
