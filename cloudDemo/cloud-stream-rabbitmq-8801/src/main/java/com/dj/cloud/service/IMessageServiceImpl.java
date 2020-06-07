package com.dj.cloud.service;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import sun.plugin2.message.Message;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)  //定义消息推送管道
public class IMessageServiceImpl implements IMessageService {

    @Resource
    private MessageChannel messageChannel; //消息发送管道

    @Override
    public String send() {
        UUID uuid = UUID.randomUUID();
        messageChannel.send(MessageBuilder.withPayload(uuid).build());
        return null;
    }
}
