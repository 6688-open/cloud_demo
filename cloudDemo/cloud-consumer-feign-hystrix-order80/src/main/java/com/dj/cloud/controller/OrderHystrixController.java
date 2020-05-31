package com.dj.cloud.controller;

import com.dj.cloud.feign.PaymentFeign;
import com.dj.cloud.pojo.CommentResult;
import com.dj.cloud.pojo.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/order/")
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_Global_Method")
public class OrderHystrixController {

        //public static final String  PAYMENT_URL= "http://localhost:8001";
        //根据服务名
        //public static final String  PAYMENT_URL= "http://CLOULD-PAYMENT-SERVICE";

        @Resource
        private PaymentFeign paymentFeign;

        /**
         * feign 测试
         * @param id
         * @return
         */
        @GetMapping("okPayment")
        public String okPayment(Integer id){
                return paymentFeign.ok(id);
        }

        /**
         *  测试超时
         *  @HystrixCommand 调用方 做降级处理
         * @return
         */
        @GetMapping("errorPayment")
//        @HystrixCommand(fallbackMethod = "paymentInfo_ERRORMethod", commandProperties = {
//                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//        })
        @HystrixCommand
        public String errorPayment(Integer id){
                int age = 10/0;
                //openfeign  ribbon  客户端默认等待一秒钟
                return paymentFeign.error(id);
        }

        /**
         *  方法 paymentInfo_ERROR  超时  卡顿 异常
         *  参数 需要一致  否则报错
         *  服务降级
         * @return
         */
        public String paymentInfo_ERRORMethod(Integer id){ //特殊指定 参数对应
                return "消费者调用提供者服务时   出现异常 卡顿  消费端降级处理";
        }



        /**
         *  没有特殊指定  统一降级的方法
         *  不需要参数
         *  服务降级
         * @return
         */
        public String paymentInfo_Global_Method(){
                return "全局降级处理  消费端降级处理";
        }










}
