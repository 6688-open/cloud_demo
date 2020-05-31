package com.dj.cloud.controller;

import com.dj.cloud.pojo.CommentResult;
import com.dj.cloud.pojo.Payment;
import com.dj.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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



}
