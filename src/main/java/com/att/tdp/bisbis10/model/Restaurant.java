package com.att.tdp.bisbis10.model;

import com.att.tdp.bisbis10.dto.NewRestaurantDto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "is_kosher")
    private boolean isKosher;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Dish> dishes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "restaurants_cuisines" , joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "cuisine")
    private List<String> cuisines = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public Restaurant() {

    }
    public Restaurant(NewRestaurantDto newRestaurant) {
        this.restaurantName = newRestaurant.getName();
        this.isKosher = newRestaurant.getIsKosher();
        this.cuisines = newRestaurant.getCuisines();
    }

    // Getters and Setters

    public Long getRestaurantId() {
        return this.restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public boolean isKosher() {
        return isKosher;
    }

    public void setKosher(boolean kosher) {
        isKosher = kosher;
    }

    public List<Dish> getRestaurantDishes() {
        return this.dishes;
    }

    public void setRestaurantDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Rating> getRestaurantRatings() {
        return this.ratings;
    }

    public void setRestaurantRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<String> getRestaurantCuisines() {
        return this.cuisines;
    }

    public void setRestaurantCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }


}
