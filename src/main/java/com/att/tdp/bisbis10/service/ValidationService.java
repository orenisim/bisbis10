package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.*;
import com.att.tdp.bisbis10.exception.ValidationException;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ValidationService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishService dishService;

    public void validateNewRestaurant(NewRestaurantDto newRestaurantDto) {
        if (StringUtils.isEmpty(newRestaurantDto.getName())) {
            throw new ValidationException("Restaurant name cannot be empty");
        }
        if (StringUtils.isEmpty(newRestaurantDto.getCuisines()) || newRestaurantDto.getCuisines().isEmpty()) {
            throw new ValidationException("At least one cuisine is required");
        }
        //If there is no isKosher field so it is'nt kosher by default.
    }

    public void validateUpdatedRestaurant(long id, NewRestaurantDto updatedRestaurantDto) {

        validateRestaurantId(id);
        // Validate name if present
        String name = updatedRestaurantDto.getName();
        if (name != null && !(name instanceof String)) {
            throw new ValidationException("Name must be a string");
        }
        // Validate cuisines if present
        List<String> cuisines = updatedRestaurantDto.getCuisines();
        if (cuisines != null) {
            for (String cuisine : cuisines) {
                if (!(cuisine instanceof String)) {
                    throw new ValidationException("Cuisine must be a string");
                }
            }
        }
        // Validate isKosher if present
        Boolean isKosher = updatedRestaurantDto.getIsKosher();
        if (isKosher != null && !(isKosher instanceof Boolean)) {
            throw new ValidationException("isKosher must be a boolean");
        }
    }

    public void validateNewRating(NewRatingDto newRating) {
        // Check if restaurant ID is valid
        validateRestaurantId(newRating.getRestaurantId());

        // Needs to check if the rating is a double value But I didn't have time

    }

    public void validateNewOrder(NewOrderDto newOrder) {
        // Validate restaurant ID
        validateRestaurantId(newOrder.getRestaurantId());

        // Validate order items
        if (CollectionUtils.isEmpty(newOrder.getOrderItems())) {
            throw new ValidationException("Order items cannot be empty");
        }
        for (OrderItemRequestBodyDto orderItem : newOrder.getOrderItems()) {
            validateOrderItem(orderItem);
        }
    }

    private void validateOrderItem(OrderItemRequestBodyDto orderItem) {
        // Validate dish ID
        if (orderItem.getDishId() == null || orderItem.getDishId() <= 0 || !dishService.existsById(orderItem.getDishId())) {
            throw new ValidationException("Invalid dish ID");
        }

        // Validate amount
        if (orderItem.getAmount() <= 0) {
            throw new ValidationException("Amount must be greater than 0");
        }
    }

    public void validateNewDish(NewDishDto newDish) {
        if (StringUtils.isEmpty(newDish.getName())) {
            throw new ValidationException("Dish name cannot be empty");
        }
        if (StringUtils.isEmpty(newDish.getDescription())) {
            throw new ValidationException("Dish description cannot be empty");
        }
        if (newDish.getPrice() <= 0) {
            throw new ValidationException("Dish price must be greater than zero");
        }
    }

    public void validateUpdatedDish(NewDishDto updatedDish) {
        if (StringUtils.isEmpty(updatedDish.getDescription()) && updatedDish.getPrice() <= 0) {
            throw new ValidationException("At least one field should be provided for updating");
        }
    }



    public void validateRestaurantId(long id) {
        if (!restaurantRepository.existsById(id)) {
            throw new ValidationException("Restaurant with ID " + id + " not found");
        }
    }
}
