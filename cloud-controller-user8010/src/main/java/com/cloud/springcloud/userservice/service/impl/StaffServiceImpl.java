package com.cloud.springcloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Staff;
import com.cloud.springcloud.userservice.mapper.StaffMapper;
import com.cloud.springcloud.userservice.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Autowired(required = false)
    StaffMapper staffMapper;
    @Override
    public boolean saveStaff(Staff staff) {
        staff.setSRegist(new Date());
        QueryWrapper<Staff> wrapper = new QueryWrapper();
        wrapper.eq("S_PHONE",staff.getSPhone());
        Integer integer = staffMapper.selectCount(wrapper);
        if (integer!=0) {return false;}
        int insert = staffMapper.insert(staff);
        if (insert==1) {return true;}else {return false;}
    }

    @Override
    public CommonResult<Page<Staff>> getStaff(Integer pn) {
        QueryWrapper<Staff> wrapper = new QueryWrapper();
        Page<Staff> page = new Page<>(pn,10);
        Page<Staff> mapIPage = staffMapper.selectPage(page,wrapper);
        if (mapIPage == null){
            return new CommonResult<Page<Staff>>(400,"没有数据");
        }
        return new CommonResult<Page<Staff>>(200,"success",mapIPage);
    }

    @Override
    public CommonResult<Page<Staff>> getStaffForname(String name) {
        QueryWrapper<Staff> wrapper = new QueryWrapper();
        wrapper.eq("S_NAME",name);

        Page<Staff> page = new Page<>(1,10);

        Page<Staff> mapIPage = staffMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Staff>>(400,"没有数据");
        }
        return new CommonResult<Page<Staff>>(200,"success",mapIPage);
    }

    @Override
    public CommonResult<Page<Staff>> getStaffForPhone(String phone) {
        QueryWrapper<Staff> wrapper = new QueryWrapper();
        wrapper.eq("S_PHONE",phone);

        Page<Staff> page = new Page<>(1,10);

        Page<Staff> mapIPage = staffMapper.selectPage(page,wrapper);

        if (mapIPage == null){
            return new CommonResult<Page<Staff>>(400,"没有数据");
        }
        return new CommonResult<Page<Staff>>(200,"success",mapIPage);
    }

    @Override
    public CommonResult updateForId(Staff staff) {
        int i = staffMapper.updateById(staff);
        if (i != 1){
            return new CommonResult(400,"更新失败");
        }
        return new CommonResult(200,"更新成功");
    }

    @Override
    public CommonResult deleteForId(int id) {
        int i = staffMapper.deleteById(id);
        if (i != 1){
            return new CommonResult(400,"删除失败");
        }
        return new CommonResult(200,"删除成功");
    }

    @Override
    public CommonResult deleteForArryId(List<Integer> ids) {
        int i = staffMapper.deleteBatchIds(ids);
        if (i == 0){
            return new CommonResult(400,"删除失败");
        }
        return new CommonResult(200,"删除成功");
    }


    @Override
    public Staff loginin(String username, String password) {
        QueryWrapper<Staff> wrapper = new QueryWrapper();
        wrapper.eq("S_PHONE",username)
                .eq("S_PASSWORD",password);
        Staff staff = staffMapper.selectOne(wrapper);
        return staff;
    }

    /**
     * 判断用户是否存在，存在返回1 不存在返回0
     * @param phone
     * @param password
     * @return
     */
    @Override
    public Integer userHave(String phone, String password) {
        QueryWrapper<Staff> wrapper = new QueryWrapper();
        wrapper.eq("S_PHONE",phone)
                .eq("S_PASSWORD",password);
        Integer integer = staffMapper.selectCount(wrapper);
        return integer;
    }
}
