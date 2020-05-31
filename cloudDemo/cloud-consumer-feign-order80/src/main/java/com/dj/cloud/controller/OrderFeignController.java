package com.dj.cloud.controller;

import com.dj.cloud.feign.PaymentFeign;
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
public class OrderFeignController {

        //public static final String  PAYMENT_URL= "http://localhost:8001";
        //根据服务名
        public static final String  PAYMENT_URL= "http://CLOULD-PAYMENT-SERVICE";

        @Resource
        private PaymentFeign paymentFeign;

        /**
         * feign 测试
         * @param id
         * @return
         */
        @GetMapping("feignPayment")
        public CommentResult<Payment> feignPayment(Long id){
                return paymentFeign.getPaymentById(id);
        }

        /**
         *  测试超时
         * @return
         */
        @GetMapping("feignPaymentTimeout")
        public String feignPaymentTimeout(){
                //openfeign  ribbon  客户端默认等待一秒钟
                return paymentFeign.feignTimeout();
        }










}
