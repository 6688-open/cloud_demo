package com.dj.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //支持nacos 动态刷新功能
@RequestMapping("/config/")
public class ConfigClientController {


    @Value("${config.info}")
    private String value;


    @GetMapping("info")
    public String info(){
        return value;
    }


}
