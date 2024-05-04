package com.att.tdp.bisbis10.dto;


import java.util.List;

//this model is responsible for the correct data transfer to the clinet
public class RestaurantDto {
    private long restaurantId;
    private String restaurantName;
    private double averageRating;
    private boolean isKosher;
    private List<String> cuisines;

    public RestaurantDto(long restaurantId, String restaurantName, double averageRating, boolean isKosher, List<String> cuisines) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

}
