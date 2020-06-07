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
import java.util.concurrent.TimeUnit;

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

    @GetMapping("getList")
    public CommentResult<List<Payment>> getList(){
        System.out.println("11111666666");
        return new CommentResult<List<Payment>>(200, "添加成功  serverPort :"+ serverPort,  paymentService.list()) ;
    }

    @PostMapping("add")
    public CommentResult<Payment> add(@RequestBody Payment payment){
        paymentService.save(payment);
        return new CommentResult<Payment>(200, "添加成功" ) ;
    }

    @GetMapping("get/{id}")
    public CommentResult<Payment> get(@PathVariable("id") Long id){
        return new CommentResult<Payment>(200, "添加成功serverPort :"+ serverPort,  paymentService.getById(id)) ;
    }
    /**
     * 服务发现 DiscoveryClient
     */
    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOULD-PAYMENT-SERVICE");
        services.forEach(s -> {
            log.info(s);
        });
        instances.forEach(instance -> {
            log.info(instance.getServiceId()+"\t" + instance.getHost()+"\t" + instance.getPort()+"\t" + instance.getUri());
        });
        return  this.discoveryClient;
    }


    /**
     * 测试ribbon 自定义轮训负载
     * @return
     */
    @GetMapping("lb")
    public String lb(){
        return serverPort ;
    }



    /**
     * 测试feign 超时
     * @return
     */
    @GetMapping("feignTimeout")
    public String feignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort ;
    }


    /**
     * 测试zipkin
     * @return
     */
    @GetMapping("paymentZipkin")
    public String paymentZipkin(){
        return "zipkin  test";
    }

}
