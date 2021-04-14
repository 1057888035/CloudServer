package com.cloud.springcloud.userservice.service.impl;

import com.cloud.springcloud.userservice.entity.Building;
import com.cloud.springcloud.userservice.mapper.BuildingMapper;
import com.cloud.springcloud.userservice.service.BuildingService;
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
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements BuildingService {

}
