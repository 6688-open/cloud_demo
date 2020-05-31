package com.dj.cloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * consul 作为注册中心  提供者服务测试
 */
@SpringBootApplication
@MapperScan("com.dj.cloud.mapper")
@EnableDiscoveryClient
public class PaymentMainConsul8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMainConsul8006.class, args);
        System.out.println("PaymentMainConsul8006 start  successfully.............");

    }
}
