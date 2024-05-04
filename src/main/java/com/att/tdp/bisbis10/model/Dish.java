package com.att.tdp.bisbis10.model;

import jakarta.persistence.*;

@Entity(name = "Dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Long dishId;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private long restaurantId;

    public Dish() {

    }
    public Dish(String dishName, String description, double price, long restaurantId) {
        this.dishName = dishName;
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
    }
    public Long getDishId() {
        return dishId;
    }
    public String getDishName() {
        return dishName;
    }
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

}
