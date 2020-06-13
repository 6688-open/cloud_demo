package com.dj.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //取消数据源的自动化配置
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.dj.cloud.mapper")
public class StorageSeataMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(StorageSeataMain2002.class, args);
        System.out.println("StorageSeataMain2002.......start ...........successfully");
    }
}
