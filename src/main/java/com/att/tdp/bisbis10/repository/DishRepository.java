package com.att.tdp.bisbis10.repository;

import com.att.tdp.bisbis10.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {
    public List<Dish> findByRestaurantRestaurantId(Long restaurantId);
}
