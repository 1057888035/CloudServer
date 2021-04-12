package com.cloud.springcloud.userservice.service.impl;

import com.cloud.springcloud.userservice.entity.Staff;
import com.cloud.springcloud.userservice.mapper.StaffMapper;
import com.cloud.springcloud.userservice.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

}
