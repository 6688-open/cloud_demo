package com.dj.cloud.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.cloud.domain.Order;
import com.dj.cloud.feign.AccountFeignService;
import com.dj.cloud.feign.StorageFeignService;
import com.dj.cloud.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService  {


    @Autowired
    private StorageFeignService storageFeignService;

    @Autowired
    private AccountFeignService accountFeignService;




    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void addOrder(Order order) {
        log.info("创建订单");
        //下订单
        this.save(order);

        //减库存
        log.info("减库存");
        storageFeignService.descCount(order.getProductId(), order.getCount());

        //扣余额
        log.info("扣余额");
        accountFeignService.descMoney(order.getUserId(), BigDecimal.valueOf(order.getMoney()));


        log.info("修改订单状态");
        order.setStatus(1);
        this.updateById(order);

    }
}
