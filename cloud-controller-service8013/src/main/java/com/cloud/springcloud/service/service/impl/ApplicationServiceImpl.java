package com.cloud.springcloud.service.service.impl;

import com.cloud.springcloud.entities.entity.Application;
import com.cloud.springcloud.service.mapper.ApplicationMapper;
import com.cloud.springcloud.service.service.ApplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户申请信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

}
