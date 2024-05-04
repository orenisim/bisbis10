package com.att.tdp.bisbis10.model;

import jakarta.persistence.*;

@Entity(name = "OrderItems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dishId;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem(){}
    public OrderItem(Dish dish, int amount, Order order) {
        this.dishId = dish;
        this.amount = amount;
        this.order = order;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }
    public Dish getDishId() {
        return dishId;
    }
    public void setDishId(Dish dishId) {
        this.dishId = dishId;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order orderId) {
        this.order = orderId;
    }

}
