package com.cloud.springcloud.Chargeservice.service.impl;

import com.cloud.springcloud.Chargeservice.entity.Power;
import com.cloud.springcloud.Chargeservice.mapper.PowerMapper;
import com.cloud.springcloud.Chargeservice.service.PowerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用电信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@Service
public class PowerServiceImpl extends ServiceImpl<PowerMapper, Power> implements PowerService {

}
