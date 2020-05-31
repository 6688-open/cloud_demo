package com.dj.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.cloud.pojo.Payment;


public interface PaymentService extends IService<Payment> {


    /**
     * 正常访问
     * @param id
     * @return
     */
    String paymentInfo_OK(Integer id);


    /**
     * 异常访问  超时
     * @param id
     * @return
     */
    String paymentInfo_ERROR(Integer id);


    //###########################服务熔断
    String paymentCircuitBreaker(Integer id);
}
