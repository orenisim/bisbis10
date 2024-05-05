package com.att.tdp.bisbis10.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id")
    private UUID orderId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {

    }
    public Order(Restaurant restaurant, List<OrderItem> orderItems) {
        this.restaurant = restaurant;
        this.orderItems = orderItems;
    }

    public UUID getOrderId() {
        return orderId;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<OrderItem> getOrderItems(){
        return orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems){
        this.orderItems = orderItems;
    }


}
