package com.att.tdp.bisbis10.mapper;

import com.att.tdp.bisbis10.dto.DishDto;
import com.att.tdp.bisbis10.dto.NewRestaurantDto;
import com.att.tdp.bisbis10.dto.RestaurantByIdDto;
import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {

    public static Restaurant toRestaurant(NewRestaurantDto newRestaurant) {
        System.out.println("----Test-----");
        newRestaurant.print();
        Restaurant restaurant = new Restaurant();
        restaurant.setName(newRestaurant.getName());
        restaurant.setKosher(newRestaurant.getIsKosher());
        restaurant.setRestaurantCuisines(newRestaurant.getCuisines());
        return restaurant;
    }

    public static RestaurantByIdDto toRestaurantByIdDto(Restaurant restaurant) {
        RestaurantByIdDto restaurantByIdDto = new RestaurantByIdDto();
        restaurantByIdDto.setRestaurantId(restaurant.getRestaurantId());
        restaurantByIdDto.setRestaurantName(restaurant.getRestaurantName());
        restaurantByIdDto.setAverageRating(restaurantByIdDto.getAverageRating());
        restaurantByIdDto.setIsKosher(restaurant.isKosher());
        restaurantByIdDto.setCuisines(restaurant.getRestaurantCuisines());
        restaurantByIdDto.setDishes(createListOfDishDto(restaurant.getRestaurantDishes()));
        return restaurantByIdDto;
    }

    public static List<DishDto> createListOfDishDto(List<Dish> dishesRestaurant) {
        List<DishDto> dishDtos = new ArrayList<DishDto>();
        for (Dish dish : dishesRestaurant) {
            DishDto dishDto = new DishDto();
            dishDto.setId(dish.getDishId());
            dishDto.setName(dish.getDishName());
            dishDto.setDescription(dish.getDescription());
            dishDto.setPrice(dish.getPrice());
            dishDtos.add(dishDto);
        }
        return dishDtos;
    }
}
