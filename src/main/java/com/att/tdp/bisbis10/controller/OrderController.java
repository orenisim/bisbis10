package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.NewOrderDto;
import com.att.tdp.bisbis10.model.Order;
import com.att.tdp.bisbis10.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<UUID> placeOrder(@RequestBody NewOrderDto newOrder) {
        UUID orderId = orderService.placeOrder(newOrder.getRestaurantId(), newOrder.getOrderItems());
        if (orderId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }
}
