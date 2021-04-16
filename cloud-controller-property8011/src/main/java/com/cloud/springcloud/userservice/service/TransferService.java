package com.cloud.springcloud.userservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Transfer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 调库申请信息 服务类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-16
 */
public interface TransferService extends IService<Transfer> {
    CommonResult<IPage<Transfer>> getAll(Integer pn);
}
