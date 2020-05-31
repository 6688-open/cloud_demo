package com.dj.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.dj.cloud.mapper")
@EnableDiscoveryClient
public class OrderMainZK80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainZK80.class, args);
        System.out.println("OrderMain start  successfully.............");

    }
}
