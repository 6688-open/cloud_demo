package com.dj.cloud.hystrix;

import com.dj.cloud.feign.PaymentFeign;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackHandler implements PaymentFeign {
    @Override
    public String ok(Integer id) {
        return "PaymentFallbackHandler 服务降级 ok";
    }

    @Override
    public String error(Integer id) {
        return " PaymentFallbackHandler 服务降级  error ";
    }
}
