package com.dj.cloud;

import com.dj.myIRule.MySelfRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@MapperScan("com.dj.cloud.mapper")
@EnableEurekaClient
//@RibbonClient(name = "CLOULD-PAYMENT-SERVICE", configuration = MySelfRule.class)//自定义负载均衡
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
        System.out.println("OrderMain start  successfully.............");

    }
}
