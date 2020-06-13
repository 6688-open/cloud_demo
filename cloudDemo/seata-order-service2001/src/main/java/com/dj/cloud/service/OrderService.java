package com.dj.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.cloud.domain.Order;

public interface OrderService extends IService<Order> {


    void addOrder(Order order);
}
