package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.NewRestaurantDto;
import com.att.tdp.bisbis10.dto.RestaurantByIdDto;
import com.att.tdp.bisbis10.dto.RestaurantsResponseDto;
import com.att.tdp.bisbis10.mapper.Mapper;
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

    private Mapper mapper;

    public List<RestaurantsResponseDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantsResponseDto> restaurantsResponseDtos = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            restaurantsResponseDtos.add(restaurantToRestaurantDto(restaurant));
        }
        return restaurantsResponseDtos;
    }

    public List<RestaurantsResponseDto> getRestaurantsByCuisine(String cuisine) {
        List<Restaurant> restaurantsByCuisineName = restaurantRepository.findByCuisinesContaining(cuisine);
        List<RestaurantsResponseDto> restaurantsResponseDtos = new ArrayList<>();
        for (Restaurant restaurant : restaurantsByCuisineName) {
            restaurantsResponseDtos.add(restaurantToRestaurantDto(restaurant));
        }
        return restaurantsResponseDtos;
    }

    public RestaurantByIdDto getRestaurantById(long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        return mapper.toRestaurantByIdDto(restaurant);
    }


    public void addRestaurant(NewRestaurantDto newRestaurant) {
        Restaurant restaurant = mapper.toRestaurant(newRestaurant);
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurantById(long id, NewRestaurantDto updatedRestaurant) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
        if (restaurant != null) {
            if (updatedRestaurant.getCuisines() != null) {
                restaurant.setRestaurantCuisines(updatedRestaurant.getCuisines());
            }
            if (updatedRestaurant.getName() != null) {
                restaurant.setName(updatedRestaurant.getName());
            }
            if (updatedRestaurant.getIsKosher() != restaurant.isKosher()) {
                restaurant.setKosher(updatedRestaurant.getIsKosher());
            }
            restaurantRepository.save(restaurant);
        }
    }

    public void deleteRestaurantById(long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }




    //Helper function-
    private RestaurantsResponseDto restaurantToRestaurantDto(Restaurant restaurant) {
        RestaurantsResponseDto restaurantsResponseDto = new RestaurantsResponseDto();
        restaurantsResponseDto.setRestaurantId(restaurant.getRestaurantId());
        restaurantsResponseDto.setRestaurantName(restaurant.getRestaurantName());
        restaurantsResponseDto.setAverageRating(averageRating(restaurant.getRestaurantRatings()));
        restaurantsResponseDto.setIsKosher(restaurant.isKosher());
        restaurantsResponseDto.setCuisines(restaurant.getRestaurantCuisines());
        return restaurantsResponseDto;
    }

    private double averageRating(List<Rating> ratings) {
        double sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getRating();
        }
        return sum / ratings.size();
    }



}





