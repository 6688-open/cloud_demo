package com.dj.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.cloud.mapper.PaymentMapper;
import com.dj.cloud.pojo.Payment;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl  extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {


    //#############################################服务降级

    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池  " + Thread.currentThread().getName()+ "paymentInfo_OK , id" + id ;
    }


    /**
     *  @HystrixCommand 报错后异常处理  @EnableCircuitBreaker 主启动类 开启
     * 提供者一方进行 服务降级  假如自身服务超时  卡顿 异常 程序报错 降级处理  备用方法
     *
     * HystrixProperty 假如3秒为返回 自身服务做降级处理
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_ERRORHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_ERROR(Integer id) {
        int time = 2;
        //int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池  " + Thread.currentThread().getName()+ "paymentInfo_ERROR , id" + id +"耗时 ：" + time;
    }




    /**
     *  方法 paymentInfo_ERROR  超时  卡顿 异常
     *  服务降级
     * @return
     */
    public String paymentInfo_ERRORHandler(Integer id){
        return "服务方降级处理";
    }





    //#############################################服务熔断

    /**
     * 服务熔断
     * HystrixCommandProperties
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),   //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期 在某个时间内
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {

        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t调用成功  流水号： "+ serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数 稍后再试，  id = "+ id;
    }









}
