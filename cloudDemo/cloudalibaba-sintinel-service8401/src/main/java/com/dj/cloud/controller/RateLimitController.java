package com.dj.cloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dj.cloud.handler.CustomerBlockHandler;
import com.dj.cloud.pojo.CommentResult;
import com.dj.cloud.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinelResource/")
public class RateLimitController {


    /**根据 @SentinelResource这个名称配置  流控根据自定义降级
     *
     * 只是违背了配置会降级  系统异常  运行异常还是会返回报错页面  不友好
     *
     *
     *
     * @return
     */
    @GetMapping("byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException_byResource")
    public CommentResult byResource(){

        return  new CommentResult(200, "按资源名限流");
    }


    public CommentResult handleException_byResource (BlockException blockException) {
        //com.alibaba.csp.sentinel.slots.block.flow.FlowException
        return  new CommentResult(444, blockException.getClass().getCanonicalName()+ "\tf服务不可用    blockHandler");
    }

    /**
     * fallback 系统异常时  会走handleFallback降级处理
     * @return
     */
    @GetMapping("fallback")
    @SentinelResource(value = "fallback",
            fallback = "handleFallback",
            blockHandler = "handleException_byResource",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommentResult fallback(){
        if (1==1) {
            throw new IllegalArgumentException("参数异常");
        }

        return  new CommentResult(200, "按资源名限流");
    }

    public CommentResult handleFallback (BlockException blockException) {
        return  new CommentResult(444, blockException.getClass().getCanonicalName()+ "\tf服务不可用   fallback");
    }



    @GetMapping("rateLimitByUrl")
    @SentinelResource(value = "rateLimitByUrl")
    public CommentResult rateLimitByUrl(){
        return  new CommentResult(200, "rateLimitByUrl");
    }

    /**
     * 自定义    customerBlockHandler
     *
     * http://localhost:8401/sentinelResource/myCustomerBlockHandler
     * @return
     */
    @GetMapping("myCustomerBlockHandler")
    @SentinelResource(value = "myCustomerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommentResult myCustomerBlockHandler(){
        return  new CommentResult(200, "customerBlockHandler   自定义");
    }

}
