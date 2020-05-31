package com.dj.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义轮询负载
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstance);
}
