package com.dj.cloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 8001 的多节点  集群模式
 */
@SpringBootApplication
@MapperScan("com.dj.cloud.mapper")
@EnableEurekaClient
public class PaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
        System.out.println("PaymentMain8002 start  successfully.............");

    }
}
