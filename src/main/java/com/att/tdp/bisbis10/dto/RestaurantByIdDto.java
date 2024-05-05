package com.att.tdp.bisbis10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"id", "name", "averageRating", "isKosher", "cuisines", "dishes"})
public class RestaurantByIdDto {
    @JsonProperty("id")
    private long restaurantId;
    @JsonProperty("name")
    private String restaurantName;
    @JsonProperty("averageRating")
    private double averageRating;
    @JsonProperty("isKosher")
    private boolean isKosher;
    @JsonProperty("cuisines")
    private List<String> cuisines;
    @JsonProperty("dishes")
    private List<DishResponseDto> dishes;

    public RestaurantByIdDto() {}

    public RestaurantByIdDto(long restaurantId, String restaurantName, double averageRating, boolean isKosher, List<String> cuisines, List<DishResponseDto> dishes) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
        this.dishes = dishes;
    }

    // Getters
    public long getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public boolean getIsKosher() {
        return isKosher;
    }

    public List<String> getCuisines() {
        return cuisines;
    }
    public List<DishResponseDto> getDishes() {
        return dishes;
    }

    // Setters
    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setIsKosher(boolean isKosher) {
        this.isKosher = isKosher;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }
    public void setDishes(List<DishResponseDto> dishes) {
        this.dishes = dishes;
    }
}
