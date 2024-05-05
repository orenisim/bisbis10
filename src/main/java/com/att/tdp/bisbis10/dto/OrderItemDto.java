package com.att.tdp.bisbis10.dto;

public class OrderItemDto {
    private Long dishId;
    int amount;

    public OrderItemDto(){

    }
    public OrderItemDto(Long dishId, int amount) {
        this.dishId = dishId;
        this.amount = amount;
    }
    public Long getDishId() {
        return dishId;
    }
    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

}


