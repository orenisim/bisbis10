package com.att.tdp.bisbis10.model;

import jakarta.persistence.*;

@Entity(name = "Ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "rating")
    private double rating;

    public Rating() {

    }
    public Rating(Restaurant restaurant, double rating) {
        this.restaurant = restaurant;
        this.rating = rating;
    }
    public Long getRatingId() {
        return ratingId;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }







}
