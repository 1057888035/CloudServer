package com.cloud.springcloud.userservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Instock;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 物料管理 服务类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
public interface InstockService extends IService<Instock> {

    CommonResult<Page<Instock>> getInstock(Integer pn);

    public CommonResult<Page<Instock>> getBuildingForName(String name,int pn);

    public CommonResult deleteForId(int id);

    public CommonResult deleteForArryId(List<Integer> ids);

}
