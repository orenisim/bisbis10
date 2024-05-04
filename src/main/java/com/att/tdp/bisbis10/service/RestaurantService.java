package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.NewRestaurantDto;
import com.att.tdp.bisbis10.dto.RestaurantDto;
import com.att.tdp.bisbis10.model.Rating;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            restaurantDtos.add(restaurantToRestaurantDto(restaurant));
        }
        return restaurantDtos;
    }

    public List<RestaurantDto> getRestaurantsByCuisine(String cuisineName) {
        List<Restaurant> restaurantsByCuisineName = restaurantRepository.findByCuisinesContaining(cuisineName);
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        for (Restaurant restaurant : restaurantsByCuisineName) {
            restaurantDtos.add(restaurantToRestaurantDto(restaurant));
        }
        return restaurantDtos;
    }

    public Restaurant getRestaurantById(long restaurantId) {
        return restaurantRepository.findById(restaurantId).orElse(null);
    }


    public void addRestaurant(NewRestaurantDto newRestaurant) {
        Restaurant restaurant = new Restaurant(newRestaurant);
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurantById(long id, Restaurant updatedRestaurant) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
        if (restaurant != null) {
            if (updatedRestaurant.getRestaurantCuisines() != null) {
                restaurant.setRestaurantCuisines(updatedRestaurant.getRestaurantCuisines());
            }
            if (updatedRestaurant.getRestaurantName() != null) {
                restaurant.setName(updatedRestaurant.getRestaurantName());
            }
            if (updatedRestaurant.isKosher() != restaurant.isKosher()) {
                restaurant.setKosher(updatedRestaurant.isKosher());
            }
            restaurantRepository.save(restaurant);
        }
    }

    public void deleteRestaurantById(long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }




    //helper function-
    private RestaurantDto restaurantToRestaurantDto(Restaurant restaurant) {
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setRestaurantId(restaurant.getRestaurantId());
        restaurantDto.setRestaurantName(restaurant.getRestaurantName());
        restaurantDto.setAverageRating(averageRating(restaurant.getRestaurantRatings()));
        restaurantDto.setKosher(restaurant.isKosher());
        restaurantDto.setCuisines(restaurant.getRestaurantCuisines());
        return restaurantDto;
    }

    private double averageRating(List<Rating> ratings) {
        double sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getRating();
        }
        return sum / ratings.size();
    }



}





