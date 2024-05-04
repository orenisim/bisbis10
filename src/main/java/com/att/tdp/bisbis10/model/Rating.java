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
    private long restaurantId;

    @Column(name = "rating")
    private double rating;

    public Rating() {

    }

    //needs to decide what to do rega
    public Rating(long restaurantId, double rating) {
        this.restaurantId = restaurantId;
        this.rating = rating;
    }

    public Long getRatingId() {
        return ratingId;
    }
    public long getRestaurantId() {
        return this.restaurantId;
    }
    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }
    public double getRating() {
        return this.rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }





}
