package com.att.tdp.bisbis10.repository;

import com.att.tdp.bisbis10.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    public List<Restaurant> findByCuisinesContaining(String cuisine);
}


