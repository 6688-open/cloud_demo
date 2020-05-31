package com.dj.cloud.feign;


import com.dj.cloud.hystrix.PaymentFallbackHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOULD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackHandler.class)
//@FeignClient(value = "clould-provider-hystrix-payment")
public interface PaymentFeign {


    @GetMapping("/payment/hystrix/ok/{id}")
    String ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/error/{id}")
    String error(@PathVariable("id") Integer id);



}
