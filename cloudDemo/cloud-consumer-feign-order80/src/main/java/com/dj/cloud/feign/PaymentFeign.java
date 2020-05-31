package com.dj.cloud.feign;


import com.dj.cloud.pojo.CommentResult;
import com.dj.cloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOULD-PAYMENT-SERVICE")
public interface PaymentFeign {


    @GetMapping("/payment/get/{id}")
    CommentResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feignTimeout")
    String feignTimeout();



}
