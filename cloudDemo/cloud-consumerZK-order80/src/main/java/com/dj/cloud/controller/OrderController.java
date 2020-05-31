package com.dj.cloud.controller;

import com.dj.cloud.pojo.CommentResult;
import com.dj.cloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order/")
@Slf4j
public class OrderController {

        //根据服务名
        public static final String  PAYMENT_URL= "http://clould-payment-service";

        @Resource
        private RestTemplate restTemplate;

        @GetMapping("paymentZk")
        public String paymentZk(){
            return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
        }

        @GetMapping("getPayment/{id}")
        public CommentResult<Payment> getPayment(@PathVariable("id") Long id){
                return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommentResult.class);
        }
}
