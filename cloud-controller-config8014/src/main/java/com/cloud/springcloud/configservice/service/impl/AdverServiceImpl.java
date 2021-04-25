package com.cloud.springcloud.configservice.service.impl;

import com.cloud.springcloud.entities.entity.Adver;
import com.cloud.springcloud.configservice.mapper.AdverMapper;
import com.cloud.springcloud.configservice.service.AdverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 广告信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@Service
public class AdverServiceImpl extends ServiceImpl<AdverMapper, Adver> implements AdverService {

}
