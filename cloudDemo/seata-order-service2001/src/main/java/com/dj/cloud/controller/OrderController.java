package com.dj.cloud.controller;

import com.dj.cloud.domain.CommentResult;
import com.dj.cloud.domain.Order;
import com.dj.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/")
public class OrderController {


    @Autowired
    private OrderService orderService;


    @PostMapping("add")
    public CommentResult add(){
        Order order = Order.builder().money(10).status(0).productId(1L).userId(1L).count(1).build();
        orderService.addOrder(order);
        return new CommentResult(200, "success");
    }

    @PostMapping("create")
    public CommentResult create(){
        Order order = Order.builder().money(10).status(0).productId(1L).userId(1L).count(1).build();
        orderService.save(order);
        return new CommentResult(200, "success");
    }
}
