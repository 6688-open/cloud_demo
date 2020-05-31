package com.dj.cloud.controller;

import com.dj.cloud.pojo.CommentResult;
import com.dj.cloud.pojo.Payment;
import com.dj.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payment/")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("zk")
    public String zk(){
        System.out.println("11111666666");
        return "zookeeper" + serverPort + UUID.randomUUID().toString();
    }









    @Resource
    private PaymentService  paymentService;


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
}
