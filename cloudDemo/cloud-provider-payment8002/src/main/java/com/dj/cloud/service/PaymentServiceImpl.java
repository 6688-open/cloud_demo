package com.dj.cloud.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.cloud.mapper.PaymentMapper;
import com.dj.cloud.pojo.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl  extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

}
