package com.att.tdp.bisbis10.dto;

import java.util.List;

public class NewOrderDto {
    private Long restaurantId;
    private List<OrderItemRequestBodyDto> orderItems;

    public NewOrderDto() {}

    public NewOrderDto(Long restaurantId, List<OrderItemRequestBodyDto> orderItems) {
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
    public List<OrderItemRequestBodyDto> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<OrderItemRequestBodyDto> orderItems) {
        this.orderItems = orderItems;
    }

}
