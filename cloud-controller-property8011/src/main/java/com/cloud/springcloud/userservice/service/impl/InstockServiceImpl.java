package com.cloud.springcloud.userservice.service.impl;

import com.cloud.springcloud.userservice.entity.Instock;
import com.cloud.springcloud.userservice.mapper.InstockMapper;
import com.cloud.springcloud.userservice.service.InstockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 房间信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
@Service
public class InstockServiceImpl extends ServiceImpl<InstockMapper, Instock> implements InstockService {

}
