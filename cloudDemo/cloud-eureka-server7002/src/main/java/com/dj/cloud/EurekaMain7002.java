package com.dj.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 7001注册中心  集群模式
 */
@SpringBootApplication
// 标注自己是注册中心
@EnableEurekaServer
public class EurekaMain7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
        System.out.println("  EurekaMain7002 start  successfully.............");

    }
}
