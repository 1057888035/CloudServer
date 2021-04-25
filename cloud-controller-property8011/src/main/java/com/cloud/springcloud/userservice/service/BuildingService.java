package com.cloud.springcloud.userservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Building;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 房间信息 服务类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-14
 */
public interface BuildingService extends IService<Building> {

    /**
     * 保存房间信息
     * @param building
     * @return
     */
    boolean saveBuilding(Building building);

    /**
     * 获取楼栋内房间信息
     * @param pn
     * @return
     */
    CommonResult<Page<Building>> getBuilding(Integer pn);

    CommonResult<Page<Building>> getBuildingForCode(Integer code);

    CommonResult<Page<Building>> getBuildingForOwnerId(Integer oid);

    /**
     * 根据id更新车辆信息
     * @param building
     * @return
     */
    CommonResult updateForId(Building building);

    /**
     * 根据id删除房间信息
     * @param id
     * @return
     */
    CommonResult deleteForId(int id);

    /**
     * 批量删除房间信息
     * @param ids
     * @return
     */
    CommonResult deleteForArryId(List<Integer> ids);



}
