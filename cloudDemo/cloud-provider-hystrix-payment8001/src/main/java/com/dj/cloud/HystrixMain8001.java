package com.dj.cloud;


import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@MapperScan("com.dj.cloud.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker  // @HystrixCommand 开启
public class HystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixMain8001.class, args);
        System.out.println("HystrixMain8001  start  successfully.............");

    }

    /**
     * 此配置是为了服务监控而配置 与服务本身容错无关
     * ServletRegistrationBean 因为springboot 默认路径不是/hystrix.stream
     * 只要在自己项目里配置上下面的Servlet就行
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean  servletRegistrationBean = new ServletRegistrationBean(streamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }


}
