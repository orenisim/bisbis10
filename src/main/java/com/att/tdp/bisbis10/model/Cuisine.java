package com.att.tdp.bisbis10.model;

import jakarta.persistence.*;

@Entity(name = "Cuisines")
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuisine_id")
    private Long cuisineId;

    @Column(name = "cuisine_name")
    private String cuisineName;

    public Cuisine() {

    }
    public Cuisine(String cuisineName) {
        this.cuisineName = cuisineName;
    }
    public Long getCuisineId() {
        return cuisineId;
    }
    public String getCuisineName() {
        return cuisineName;
    }
    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

}
