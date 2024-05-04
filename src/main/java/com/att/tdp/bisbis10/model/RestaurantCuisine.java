package com.att.tdp.bisbis10.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "RestaurantsCuisines")
public class RestaurantCuisine {

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    private Long restaurantId;

    @ManyToOne
    @JoinColumn(name = "cuisine_id", referencedColumnName = "cuisine_id")
    private Long cuisineId;

    public RestaurantCuisine() {

    }
    public RestaurantCuisine(Long restaurantId, Long cuisineId) {
        this.restaurantId = restaurantId;
        this.cuisineId = cuisineId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
    public Long getCuisineId() {
        return cuisineId;
    }
    public void setCuisineId(Long cuisineId) {
        this.cuisineId = cuisineId;
    }

}
