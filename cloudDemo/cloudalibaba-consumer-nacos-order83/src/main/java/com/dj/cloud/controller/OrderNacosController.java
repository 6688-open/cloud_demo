package com.dj.cloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order/")
@Slf4j
public class OrderNacosController {


    @Resource
    private RestTemplate restTemplate;


    @Value("${service-url.nacos-user-service}")
    private String serverUrl;


    @GetMapping("getPayment/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return  restTemplate.getForObject(serverUrl+"/payment/getPayment/"+ id, String.class);
    }


}
