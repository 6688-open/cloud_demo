package com.dj.myIRule;


import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义 负载均衡
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myIRule(){
        return new RandomRule();    //自定义随机
    }
}
