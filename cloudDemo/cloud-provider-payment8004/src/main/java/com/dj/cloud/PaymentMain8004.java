package com.dj.cloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * zookeeper 作为注册中心  提供者服务测试
 */
@SpringBootApplication
@MapperScan("com.dj.cloud.mapper")
@EnableDiscoveryClient
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
        System.out.println("PaymentMain8004 start  successfully.............");

    }
}
