package com.cloud.springcloud.Chargeservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.springcloud.Chargeservice.entity.Dock;
import com.cloud.springcloud.Chargeservice.mapper.DockMapper;
import com.cloud.springcloud.Chargeservice.service.DockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.DateUtilss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataUnit;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 停车收费信息 服务实现类
 * </p>
 *
 * @author wangcheng
 * @since 2021-04-18
 */
@Service
public class DockServiceImpl extends ServiceImpl<DockMapper, Dock> implements DockService {

    @Autowired(required = false)
    DockMapper dockMapper;


    /**
     * List<Dock> docks = dockMapper.selectList(wrapper); 获取到已经进入小区但未离开的车辆
     *  dockMapper.updateById(docker);   对该车辆进行登出操作
     *       dock.setDoMoney(new BigDecimal(100.00));还要计算费率
     * @param dock
     * @return
     */
    @Override
    public CommonResult loginout(Dock dock) {
        int i=0;
        QueryWrapper<Dock> wrapper = new QueryWrapper();
        wrapper.eq("DO_NUM", dock.getDoNum());
        List<Dock> docks = dockMapper.selectList(wrapper);
        for (Dock docker : docks) {
            if (docker.getGmtOut() == null) {
                docker.setGmtOut(dock.getGmtOut());
                //这里要计算费率并设置
                dock.setDoMoney(new BigDecimal(DateUtilss.dateTogether(docker.getGmtIn(),docker.getGmtOut())));
                 i = dockMapper.updateById(docker);
            }
        }
        return new CommonResult(200,"影响行数",i);
    }


}
