package com.att.tdp.bisbis10.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Long restaurantId;

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {

    }
    public Order(Long restaurantId, List<OrderItem> orderItems) {
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }

    public Long getOrderId() {
        return orderId;
    }
    public Long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItem> getOrderItems(){
        return orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems){
        this.orderItems = orderItems;
    }


}
