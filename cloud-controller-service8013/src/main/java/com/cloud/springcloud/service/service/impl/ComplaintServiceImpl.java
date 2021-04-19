package com.cloud.springcloud.service.service.impl;

import com.cloud.springcloud.service.entity.Complaint;
import com.cloud.springcloud.service.mapper.ComplaintMapper;
import com.cloud.springcloud.service.service.ComplaintService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客诉信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-19
 */
@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements ComplaintService {

}
