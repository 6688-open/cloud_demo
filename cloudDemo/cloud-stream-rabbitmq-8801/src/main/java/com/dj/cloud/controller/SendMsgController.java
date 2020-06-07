package com.dj.cloud.controller;

import com.dj.cloud.service.IMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMsgController {


    @Resource
    private IMessageService iMessageService;


    @GetMapping("/sendMsg")
    public String sendMsg(){
        return  iMessageService.send();
    }
}
