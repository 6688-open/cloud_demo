package com.dj.cloud.controller;

import com.dj.cloud.lb.LoadBalancer;
import com.dj.cloud.pojo.CommentResult;
import com.dj.cloud.pojo.Payment;
import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order/")
@Slf4j
public class OrderController {

        //public static final String  PAYMENT_URL= "http://localhost:8001";
        //根据服务名
        public static final String  PAYMENT_URL= "http://CLOULD-PAYMENT-SERVICE";

        @Resource
        private RestTemplate restTemplate;

        @Resource
        private LoadBalancer loadBalancer;
        /**
         * 服务发现 DiscoveryClient         import org.springframework.cloud.client.discovery.DiscoveryClient;
         */
        @Resource
        private DiscoveryClient discoveryClient;

        @GetMapping("addPayment")
        public CommentResult<Payment> addPayment(Payment payment){
            return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, CommentResult.class);
        }

        @GetMapping("getPayment/{id}")
        public CommentResult<Payment> getPayment(@PathVariable("id") Long id){
                return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommentResult.class);
        }


        /**
         * getForEntity
         * @param id
         * @return
         */
        @GetMapping("getPayment1/{id}")
        public CommentResult getPayment1(@PathVariable("id") Long id){
                ResponseEntity<CommentResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommentResult.class);
                if (entity.getStatusCode().is2xxSuccessful()) {
                        return entity.getBody();
                } else {
                        return new CommentResult(201, "error");
                }
        }


        /**
         * 自定义轮询负载
         */
        @GetMapping("getBalance")
        public String getPaymentLB(){
                List<ServiceInstance> instances = discoveryClient.getInstances("CLOULD-PAYMENT-SERVICE");
                if (CollectionUtils.isEmpty(instances)) {
                        return null;
                }
                ServiceInstance instance = loadBalancer.instance(instances);
                URI uri = instance.getUri();
                return restTemplate.getForObject(uri + "payment/lb", String.class);
        }


        /**
         * 测试 zipkin
         * @return
         */
        @GetMapping("getPaymentZipkin")
        public String getPaymentZipkin(){
                return restTemplate.getForObject(PAYMENT_URL+"/payment/paymentZipkin", String.class);
        }





}
