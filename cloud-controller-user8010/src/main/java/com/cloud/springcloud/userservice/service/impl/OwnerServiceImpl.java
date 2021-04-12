package com.cloud.springcloud.userservice.service.impl;

import com.cloud.springcloud.userservice.entity.Owner;
import com.cloud.springcloud.userservice.mapper.OwnerMapper;
import com.cloud.springcloud.userservice.service.OwnerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业主信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
@Service
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements OwnerService {

}
