package com.att.tdp.bisbis10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants/{id}/dishes")
public class DisheController {

    @Autowired
    private DishService dishService;

    @PostMapping
    public ResponseEntity<Void> addDishToRestaurantById(@PathVariable long  restaurantId , @RequestBody Dish dish) {
        dishService.addDishToRestaurantById(restaurantId, dish);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<Void> updateDishById(@PathVariable long restaurantId, @PathVariable long dishId, @RequestBody Dish dish) {
        dishService.updateDishById(restaurantId, dishId, dish);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{dishId}")
    public ResponseEntity<Void> deleteDishById(@PathVariable long restaurantId, @PathVariable long dishId) {
        dishService.deleteDishById(restaurantId, dishId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Dish>> getDishesByRestaurantId(@PathVariable long restaurantId) {
        List<Dish> dishes = dishService.getDishesByRestaurantId(restaurantId);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }


}
