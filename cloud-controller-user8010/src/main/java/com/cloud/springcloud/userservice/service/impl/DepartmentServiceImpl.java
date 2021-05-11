package com.cloud.springcloud.userservice.service.impl;

import com.cloud.springcloud.userservice.entity.Department;
import com.cloud.springcloud.userservice.mapper.DepartmentMapper;
import com.cloud.springcloud.userservice.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-05-08
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

}
