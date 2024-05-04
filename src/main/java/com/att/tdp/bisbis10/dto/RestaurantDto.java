package com.att.tdp.bisbis10.dto;


import java.util.List;

//this model is responsible for the correct data transfer to the clinet
public class RestaurantDto {
    private long restaurantId;
    private String restaurantName;
    private double averageRating;
    private boolean isKosher;
    private List<String> cuisines;

    public RestaurantDto() {}

    public RestaurantDto(long restaurantId, String restaurantName, double averageRating, boolean isKosher, List<String> cuisines) {
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

    public boolean isKosher() {
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

    public void setKosher(boolean isKosher) {
        this.isKosher = isKosher;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }


}
