package com.cloud.springcloud.Chargeservice.service.impl;

import com.cloud.springcloud.Chargeservice.entity.Property;
import com.cloud.springcloud.Chargeservice.mapper.PropertyMapper;
import com.cloud.springcloud.Chargeservice.service.PropertyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 物业费用信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@Service
public class PropertyServiceImpl extends ServiceImpl<PropertyMapper, Property> implements PropertyService {

}
