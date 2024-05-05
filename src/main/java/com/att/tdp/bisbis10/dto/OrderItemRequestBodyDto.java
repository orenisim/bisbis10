package com.att.tdp.bisbis10.dto;

//Represent how OrderItem looks in the  list in the post body to the order API
public class OrderItemRequestBodyDto {
    private Long dishId;
    int amount;

    public OrderItemRequestBodyDto(){

    }
    public OrderItemRequestBodyDto(Long dishId, int amount) {
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


