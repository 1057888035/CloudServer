package com.cloud.springcloud.userservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Car;
import com.cloud.springcloud.userservice.entity.Owner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 业主信息 服务类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
public interface OwnerService extends IService<Owner> {

    boolean saveOwner(Owner owner);

    CommonResult<Page<Owner>> getOwner(Integer pn);

    CommonResult<Page<Owner>> getOwnerForId(Integer id);

    CommonResult<Page<Owner>> getOwnerForPhone(String phone);

    CommonResult updateForId(Owner owner);

    CommonResult deleteForId(int id);

    CommonResult deleteForArryId(List<Integer> ids);

    Owner loginin(String username,String password);
}
