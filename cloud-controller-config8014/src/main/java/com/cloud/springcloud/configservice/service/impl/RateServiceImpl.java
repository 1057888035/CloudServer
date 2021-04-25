package com.cloud.springcloud.configservice.service.impl;

import com.cloud.springcloud.entities.entity.Rate;
import com.cloud.springcloud.configservice.mapper.RateMapper;
import com.cloud.springcloud.configservice.service.RateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收费费率信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@Service
public class RateServiceImpl extends ServiceImpl<RateMapper, Rate> implements RateService {

}
