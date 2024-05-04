package com.att.tdp.bisbis10.dto;

import java.util.List;

public class NewRestaurantDto {
    private String restaurantName;
    private boolean isKosher;
    private List<String> cuisines;

    public NewRestaurantDto() {}

    public NewRestaurantDto(String restaurantName, boolean isKosher, List<String> cuisines) {
        this.restaurantName = restaurantName;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    public boolean isKosher() {
        return isKosher;
    }
    public void setKosher(boolean kosher) {
        isKosher = kosher;
    }
    public List<String> getCuisines() {
        return cuisines;
    }
    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

}
