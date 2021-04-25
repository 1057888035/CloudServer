package com.cloud.springcloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Building;
import com.cloud.springcloud.userservice.mapper.BuildingMapper;
import com.cloud.springcloud.userservice.service.BuildingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired(required = false)
    BuildingMapper buildingMapper;
    @Override
    public boolean saveBuilding(Building building) {
        QueryWrapper<Building> wrapper = new QueryWrapper();
        wrapper.eq("B_CODE",building.getBCode());
        Integer integer = buildingMapper.selectCount(wrapper);
        if (integer!=0) {return false;}
        int insert = buildingMapper.insert(building);
        if (insert==1) {return true;}else {return false;}
    }

    @Override
    public CommonResult<Page<Building>> getBuilding(Integer pn) {
        QueryWrapper<Building> wrapper = new QueryWrapper();

        Page<Building> page = new Page<>(pn,10);

        Page<Building> mapIPage = buildingMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Building>>(400,"没有数据");
        }
        return new CommonResult<Page<Building>>(200,"success",mapIPage);
    }

    @Override
    public CommonResult<Page<Building>> getBuildingForCode(Integer code) {
        QueryWrapper<Building> wrapper = new QueryWrapper();
        wrapper.eq("B_CODE",code);

        Page<Building> page = new Page<>(1,10);

        Page<Building> mapIPage = buildingMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Building>>(400,"没有数据");
        }
        return new CommonResult<Page<Building>>(200,"success",mapIPage);
    }

    @Override
    public CommonResult<Page<Building>> getBuildingForOwnerId(Integer oid) {
        QueryWrapper<Building> wrapper = new QueryWrapper();
        wrapper.eq("B_OWNER_ID",oid);

        Page<Building> page = new Page<>(1,10);

        Page<Building> mapIPage = buildingMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Building>>(400,"没有数据");
        }
        return new CommonResult<Page<Building>>(200,"success",mapIPage);
    }

    @Override
    public CommonResult updateForId(Building building) {
        int i = buildingMapper.updateById(building);
        if (i != 1){
            return new CommonResult(400,"更新失败");
        }
        return new CommonResult(200,"更新成功");
    }

    @Override
    public CommonResult deleteForId(int id) {
        int i = buildingMapper.deleteById(id);
        if (i != 1){
            return new CommonResult(400,"删除失败");
        }
        return new CommonResult(200,"删除成功");
    }

    @Override
    public CommonResult deleteForArryId(List<Integer> ids) {
        int i = buildingMapper.deleteBatchIds(ids);
        if (i == 0){
            return new CommonResult(400,"删除失败");
        }
        return new CommonResult(200,"删除成功");
    }

}
