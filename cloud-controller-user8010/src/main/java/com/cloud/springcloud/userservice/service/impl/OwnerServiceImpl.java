package com.cloud.springcloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Car;
import com.cloud.springcloud.userservice.entity.Owner;
import com.cloud.springcloud.userservice.mapper.OwnerMapper;
import com.cloud.springcloud.userservice.service.OwnerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 业主信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
@Service
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements OwnerService {
    @Autowired(required = false)
    OwnerMapper ownerMapper;

    /**
     * 保存业主信息
     * @param owner
     * @return
     */
    @Override
    public boolean saveOwner(Owner owner) {
        owner.setORegist(new Date());
        QueryWrapper<Owner> wrapper = new QueryWrapper();
        wrapper.eq("O_USER",owner.getOUser());
        Integer integer = ownerMapper.selectCount(wrapper);
        if (integer!=0) {return false;}
        int insert = ownerMapper.insert(owner);
        if (insert==1) {return true;}else {return false;}
    }


    /**
     * 获取所有业主
     * @param pn
     * @return
     */
    @Override
    public CommonResult<Page<Owner>> getOwner(Integer pn) {
        QueryWrapper<Owner> wrapper = new QueryWrapper();

        Page<Owner> page = new Page<>(pn,10);

        Page<Owner> mapIPage = ownerMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Owner>>(400,"没有数据");
        }
        return new CommonResult<Page<Owner>>(200,"success",mapIPage);
    }


    /**
     * 根据id获取业主
     * @param id
     * @return
     */
    @Override
    public CommonResult<Page<Owner>> getOwnerForId(Integer id) {
        QueryWrapper<Owner> wrapper = new QueryWrapper();
        wrapper.eq("O_ID",id);

        Page<Owner> page = new Page<>(1,10);

        Page<Owner> mapIPage = ownerMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Owner>>(400,"没有数据");
        }
        return new CommonResult<Page<Owner>>(200,"success",mapIPage);
    }


    /**
     * 根据手机号获取业主
     * @param phone
     * @return
     */
    @Override
    public CommonResult<Page<Owner>> getOwnerForPhone(String phone) {
        QueryWrapper<Owner> wrapper = new QueryWrapper();
        wrapper.eq("O_PHONE",phone);

        Page<Owner> page = new Page<>(1,10);

        Page<Owner> mapIPage = ownerMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Owner>>(400,"没有数据");
        }
        return new CommonResult<Page<Owner>>(200,"success",mapIPage);
    }


    /**
     * 根据id跟新业主信息
     * @param owner
     * @return
     */
    @Override
    public CommonResult updateForId(Owner owner) {
        int i = ownerMapper.updateById(owner);
        if (i != 1){
            return new CommonResult(400,"更新失败");
        }
        return new CommonResult(200,"更新成功");
    }

    /**
     * 根据id删除单个业主信息
     * @param id
     * @return
     */
    @Override
    public CommonResult deleteForId(int id) {
        int i = ownerMapper.deleteById(id);
        if (i != 1){
            return new CommonResult(400,"删除失败");
        }
        return new CommonResult(200,"删除成功");
    }


    /**
     * 根据id删除多个业主信息
     * @param ids
     * @return
     */
    @Override
    public CommonResult deleteForArryId(List<Integer> ids) {
        int i = ownerMapper.deleteBatchIds(ids);
        if (i == 0){
            return new CommonResult(400,"删除失败");
        }
        return new CommonResult(200,"删除成功");
    }


    /**
     * 业主登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public Owner loginin(String username, String password) {
        QueryWrapper<Owner> wrapper = new QueryWrapper();
        wrapper.eq("O_USER",username)
                .eq("O_PASSWORD",password);
        Owner owner = ownerMapper.selectOne(wrapper);
        return owner;
    }
}
