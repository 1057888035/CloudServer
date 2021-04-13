package com.cloud.springcloud.userservice.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.userservice.entity.Owner;
import com.cloud.springcloud.userservice.entity.Staff;
import com.cloud.springcloud.userservice.mapper.StaffMapper;
import com.cloud.springcloud.userservice.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
    @Override
    public boolean saveStaff(Staff staff) {
        return false;
    }

    @Override
    public CommonResult<Page<Staff>> getStaff(Integer pn) {
        return null;
    }

    @Override
    public CommonResult<Page<Staff>> getStaffForname(String name) {
        return null;
    }

    @Override
    public CommonResult<Page<Staff>> getStaffForPhone(String phone) {
        return null;
    }

    @Override
    public CommonResult updateForId(Owner owner) {
        return null;
    }

    @Override
    public CommonResult deleteForId(int id) {
        return null;
    }

    @Override
    public CommonResult deleteForArryId(List<Integer> ids) {
        return null;
    }

    @Override
    public Owner loginin(String username, String password) {
        return null;
    }
}
