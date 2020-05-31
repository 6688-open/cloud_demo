package com.dj.cloud.controller;

import com.dj.cloud.pojo.CommentResult;
import com.dj.cloud.pojo.Payment;
import com.dj.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment/")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService  paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 服务发现 DiscoveryClient         import org.springframework.cloud.client.discovery.DiscoveryClient;
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        String info_ok = paymentService.paymentInfo_OK(id);
        log.info(info_ok);
        return info_ok;
    }


    @GetMapping("hystrix/error/{id}")
    public String error(@PathVariable("id") Integer id){
        String info_error = paymentService.paymentInfo_ERROR(id);
        log.info(info_error);
        return info_error;
    }






    //#############################################服务熔断

    @GetMapping("circuit/{id}")
    public String circuit(@PathVariable("id") Integer id){
        String circuitBreaker = paymentService.paymentCircuitBreaker(id);
        log.info(circuitBreaker);
        return circuitBreaker;
    }



}
