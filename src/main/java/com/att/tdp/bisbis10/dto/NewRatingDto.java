package com.att.tdp.bisbis10.dto;

public class NewRatingDto {
    private long restaurantId;
    private double rating;

    public NewRatingDto(){}

    public NewRatingDto(long restaurantId, double rating) {
        this.restaurantId = restaurantId;
        this.rating = rating;
    }
    public long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

}
