package com.dj.cloud.handler;

import com.dj.cloud.pojo.CommentResult;

public class CustomerBlockHandler {

    public static CommentResult handlerException(){
        return new CommentResult(555, "自定义限流处理器  11111111111");
    }



    public static CommentResult handlerException2(){
        return new CommentResult(555, "自定义限流处理器     2222222");
    }
}
