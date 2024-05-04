package com.att.tdp.bisbis10.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private long restaurantId;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "is_kosher")
    private boolean isKosher;

    @OneToMany(mappedBy = "restaurant_id", cascade = CascadeType.ALL)
    @Column(name = "restaurant_ratings")
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant_id", cascade = CascadeType.ALL)
    @Column(name = "dishes")
    private List<Dish> dishes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "RestaurantsCuisines",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "cuisine_id")
    )
    private List<Cuisine> cuisines = new ArrayList<>();

    public Restaurant() {

    }
    public Restaurant(String restaurantName, boolean isKosher, List<Cuisine> cuisines) {
        super();
        this.restaurantName = restaurantName;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    // Getters and Setters

    public Long getRestaurantId() {
        return this.restaurantId;
    }

    public String getRestaurantName() {
        return this.restaurantName;
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

    public List<Cuisine> getRestaurantCuisines() {
        return this.cuisines;
    }

    public void setRestaurantCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }


}
