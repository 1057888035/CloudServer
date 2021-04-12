package com.cloud.springcloud.service.imp;

import com.cloud.springcloud.dao.PaymentDao;
import com.cloud.springcloud.entities.Payment;
import com.cloud.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl  implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
            return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
            return paymentDao.getPaymentById(id);
    }
}


