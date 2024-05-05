package com.att.tdp.bisbis10.dto;

import java.util.UUID;

public class OrderResponseDto {
    private UUID orderId;

    public OrderResponseDto(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
