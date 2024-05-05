package com.att.tdp.bisbis10.dto;

import com.att.tdp.bisbis10.model.OrderItem;

import java.util.List;

public class NewOrderDto {
    private Long restaurantId;
    private List<OrderItemDto> orderItems;

    public NewOrderDto() {}

    public NewOrderDto(Long restaurantId, List<OrderItemDto> orderItems) {
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

}
