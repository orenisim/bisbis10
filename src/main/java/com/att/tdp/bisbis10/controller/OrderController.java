package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.NewOrderDto;
import com.att.tdp.bisbis10.dto.OrderResponseDto;
import com.att.tdp.bisbis10.exception.ValidationException;
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
    public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody NewOrderDto newOrder) {
        logger.info("Placing new order: {}", newOrder);
        validationService.validateNewOrder(newOrder);
        try {
            UUID orderId = orderService.placeOrder(newOrder.getRestaurantId(), newOrder.getOrderItems());
            OrderResponseDto responseDto = new OrderResponseDto(orderId);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (ValidationException e) {
            logger.error("Failed to place new order: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Failed to place new order: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
