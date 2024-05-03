package com.att.tdp.bisbis10.restaurants;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float averageRating;
    private boolean isKosher;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> cuisines;

    public Restaurant() {

    }
    public Restaurant(String name, float averageRating, boolean isKosher, List<String> cuisines) {
        super();
        this.name = name;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

}
