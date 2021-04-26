package com.cloud.springcloud.userservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 员工信息 服务类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-09
 */
public interface StaffService extends IService<Staff> {

    boolean saveStaff(Staff staff);

    CommonResult<Page<Staff>> getStaff(Integer pn);

    CommonResult<Page<Staff>> getStaffForname(String name);

    CommonResult<Page<Staff>> getStaffForPhone(String phone);

    String getPasswordForPhone(String phone);

    CommonResult updateForId(Staff staff);

    CommonResult deleteForId(int id);

    CommonResult deleteForArryId(List<Integer> ids);

    Staff loginin(String username,String password);

    Integer userHave(String phone,String password);
}
