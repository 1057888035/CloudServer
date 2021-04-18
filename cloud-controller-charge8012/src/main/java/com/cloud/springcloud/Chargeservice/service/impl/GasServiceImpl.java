package com.cloud.springcloud.Chargeservice.service.impl;

import com.cloud.springcloud.Chargeservice.entity.Gas;
import com.cloud.springcloud.Chargeservice.mapper.GasMapper;
import com.cloud.springcloud.Chargeservice.service.GasService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用气信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@Service
public class GasServiceImpl extends ServiceImpl<GasMapper, Gas> implements GasService {

}
