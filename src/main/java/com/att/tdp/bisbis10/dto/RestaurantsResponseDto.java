package com.att.tdp.bisbis10.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

//this model is responsible for the correct data transfer to the clinet
@JsonPropertyOrder({"id", "name", "averageRating", "isKosher", "cuisines"})
public class RestaurantsResponseDto {
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

    public RestaurantsResponseDto() {}

    public RestaurantsResponseDto(long restaurantId, String restaurantName, double averageRating, boolean isKosher, List<String> cuisines) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
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


}
