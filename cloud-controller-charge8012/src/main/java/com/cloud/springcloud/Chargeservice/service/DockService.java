package com.cloud.springcloud.Chargeservice.service;

import com.cloud.springcloud.entities.entity.Dock;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.springcloud.entities.CommonResult;

/**
 * <p>
 * 停车收费信息 服务类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
public interface DockService extends IService<Dock> {

    CommonResult loginout(Dock dock);

}
