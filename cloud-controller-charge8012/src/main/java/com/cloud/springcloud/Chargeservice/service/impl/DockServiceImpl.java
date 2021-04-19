package com.cloud.springcloud.Chargeservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.springcloud.Chargeservice.entity.Dock;
import com.cloud.springcloud.Chargeservice.mapper.DockMapper;
import com.cloud.springcloud.Chargeservice.service.DockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.springcloud.entities.CommonResult;
import com.cloud.springcloud.entities.DateUtilss;
import com.cloud.springcloud.entities.PayOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
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

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired(required = false)
    DockMapper dockMapper;

    @Autowired
    private RestTemplate template;


    /**
     * List<Dock> docks = dockMapper.selectList(wrapper); 获取到已经进入小区但未离开的车辆
     *  dockMapper.updateById(docker);   对该车辆进行登出操作
     *       dock.setDoMoney(new BigDecimal(100.00));还要计算费率
     * @param dock
     * @return
     */
    @Override
    public CommonResult loginout(Dock dock) {
        dock.setGmtOut(new Date());
        int i=0;
        QueryWrapper<Dock> wrapper = new QueryWrapper();
        wrapper.eq("DO_NUM", dock.getDoNum());
        List<Dock> docks = dockMapper.selectList(wrapper);

        for (Dock docker : docks) {
            if (docker.getGmtOut() == null) {
                docker.setGmtOut(dock.getGmtOut());
                //这里要计算费率并设置
                BigDecimal bigDecimal = new BigDecimal(((((DateUtilss.dateTogether(docker.getGmtIn(), docker.getGmtOut())/1000)/60))/60)/*这里还要乘以费率，暂时没算*/);
                docker.setDoMoney(bigDecimal);
                System.out.println(docker.toString());
                 i = dockMapper.updateById(docker);
                 //跳转到停车收费页面
                PayOrder payOrder = new PayOrder();
                payOrder.setOut_trade_no(docker.getDoId()+"");
                payOrder.setBody("车辆:"+docker.getDoNum()+"的停车费用");
                payOrder.setSubject("停车收费");
                payOrder.setTotal_amount(bigDecimal+"");
                payOrder.setProduct_code(""+docker.getDoId()+bigDecimal);
                String s = template.postForObject(PAYMENT_URL + "/payment/create", docker, String.class);
                return new CommonResult(200,"success",s);
            }
        }
        return new CommonResult(400,"错误");
    }


}
