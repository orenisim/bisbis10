package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.NewOrderDto;
import com.att.tdp.bisbis10.service.OrderService;
import com.att.tdp.bisbis10.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private ValidationService validationService;

    @PostMapping
    public ResponseEntity<UUID> placeOrder(@RequestBody NewOrderDto newOrder) {
        logger.info("Placing new order: {}", newOrder);
        validationService.validateNewOrder(newOrder);
        try {
            UUID orderId = orderService.placeOrder(newOrder.getRestaurantId(), newOrder.getOrderItems());
            return new ResponseEntity<>(orderId, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Failed to place new order: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
