package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.NewRestaurantDto;
import com.att.tdp.bisbis10.dto.RestaurantByIdDto;
import com.att.tdp.bisbis10.dto.RestaurantDto;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants(){
        List<RestaurantDto> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping(params = "cuisine")
    public ResponseEntity<List<RestaurantDto>> getRestaurantsByCuisine(@RequestParam String cuisine) {
        System.out.println("------- Check QUery -----" + cuisine);
        List<RestaurantDto> restaurants = restaurantService.getRestaurantsByCuisine(cuisine);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantByIdDto> getRestaurantById(@PathVariable long id) {
        RestaurantByIdDto restaurant = restaurantService.getRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addRestaurant(@RequestBody NewRestaurantDto newRestaurant) {
        restaurantService.addRestaurant(newRestaurant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRestaurantById(@PathVariable long id, @RequestBody NewRestaurantDto updatedRestaurant) {
        restaurantService.updateRestaurantById(id, updatedRestaurant);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurantById(@PathVariable long id) {
        restaurantService.deleteRestaurantById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
