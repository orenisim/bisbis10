package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.DishDto;
import com.att.tdp.bisbis10.dto.NewDishDto;
import com.att.tdp.bisbis10.mapper.Mapper;
import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.DishRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    private Mapper mapper;

    public void addDishToRestaurantById(Long restaurantId, NewDishDto newDish) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();

            // Create a new Rating entity
            Dish dish = new Dish();
            dish.setRestaurant(restaurant);
            dish.setDishName(newDish.getName());
            dish.setDescription(newDish.getDescription());
            dish.setPrice(newDish.getPrice());

            // Save the Dish
            dishRepository.save(dish);
        }
    }

    public void updateDishById(long restaurantId, long dishId , NewDishDto updatedDish) {
        Dish dish = dishRepository.findById(dishId).orElse(null);

        if (dish != null) {
            if (updatedDish.getName() != null) {
                dish.setDishName(updatedDish.getName());
            }
            if (updatedDish.getDescription() != null) {
                dish.setDescription(updatedDish.getDescription());
            }
            if (updatedDish.getPrice() != dish.getPrice()) {
                dish.setPrice(updatedDish.getPrice());
            }
            dishRepository.save(dish);
        }
    }

    public void deleteDishById(long restaurantId, long dishId) {
        Dish dish = dishRepository.findById(dishId).orElse(null);
        if (dish != null) {
            dishRepository.delete(dish);
        }

    }

    public List<DishDto> getDishesByRestaurantId(long restaurantId) {
        List<Dish> dishes = dishRepository.findByRestaurantRestaurantId(restaurantId);
        List<DishDto> dishDtos = mapper.createListOfDishDto(dishes);
        return dishDtos;
    }

    public boolean existsById(Long dishId) {
        return dishRepository.existsById(dishId);
    }
}
