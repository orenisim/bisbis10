package com.att.tdp.bisbis10.dto;

import java.util.List;

public class NewRestaurantDto {
    private String name;
    private boolean isKosher;
    private List<String> cuisines;

    public NewRestaurantDto() {}

    public NewRestaurantDto(String name, boolean isKosher, List<String> cuisines) {
        this.name = name;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public String getName() {
        return name;
    }
    public void setName(String restaurantName) {
        this.name = restaurantName;
    }
    public boolean getIsKosher() {
        return isKosher;
    }
    public void setIsKosher(boolean kosher) {
        isKosher = kosher;
    }
    public List<String> getCuisines() {
        return cuisines;
    }
    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

    //Testing Function -->
    public void print() {
        System.out.println("New Restaurant: ");
        System.out.println(this.getName());
        System.out.println(this.getIsKosher());
        System.out.println(this.getCuisines());

    }

}
