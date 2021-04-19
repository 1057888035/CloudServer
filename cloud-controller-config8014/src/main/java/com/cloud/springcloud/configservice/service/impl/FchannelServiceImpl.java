package com.cloud.springcloud.configservice.service.impl;

import com.cloud.springcloud.configservice.entity.Fchannel;
import com.cloud.springcloud.configservice.mapper.FchannelMapper;
import com.cloud.springcloud.configservice.service.FchannelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付配置信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@Service
public class FchannelServiceImpl extends ServiceImpl<FchannelMapper, Fchannel> implements FchannelService {

}
