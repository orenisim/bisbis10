package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Order;
import com.att.tdp.bisbis10.model.OrderItem;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public Long placeOrder(Restaurant restaurant, List<OrderItem> orderItems) {
        Order newOrder = new Order(restaurant, orderItems);
        Long orderId = orderRepository.save(newOrder).getOrderId();
        return orderId;
    }
}
