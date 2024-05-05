package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.NewRestaurantDto;
import com.att.tdp.bisbis10.dto.RestaurantByIdDto;
import com.att.tdp.bisbis10.dto.RestaurantDto;
import com.att.tdp.bisbis10.service.RestaurantService;
import com.att.tdp.bisbis10.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private static final Logger logger =  LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ValidationService validationService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants(){
        logger.info("Fetching all restaurants");
        List<RestaurantDto> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping(params = "cuisine")
    public ResponseEntity<List<RestaurantDto>> getRestaurantsByCuisine(@RequestParam String cuisine) {
        logger.info("Fetching restaurants by cuisine: " + cuisine);
        List<RestaurantDto> restaurants = restaurantService.getRestaurantsByCuisine(cuisine);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantByIdDto> getRestaurantById(@PathVariable long id) {
        logger.info("Fetching restaurant by id: {}" + id);
        validationService.validateRestaurantId(id);
        RestaurantByIdDto restaurant = restaurantService.getRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addRestaurant(@RequestBody NewRestaurantDto newRestaurant) {
        logger.info("Adding new restaurant: " + newRestaurant);
        validationService.validateNewRestaurant(newRestaurant);
        restaurantService.addRestaurant(newRestaurant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRestaurantById(@PathVariable long id, @RequestBody NewRestaurantDto updatedRestaurant) {
        logger.info("Updating restaurant with Id {} : {} " + updatedRestaurant  + id);
        validationService.validateUpdatedRestaurant(id, updatedRestaurant);
        restaurantService.updateRestaurantById(id, updatedRestaurant);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurantById(@PathVariable long id) {
        logger.info("Deleting restaurant with Id " + id);
        validationService.validateRestaurantId(id);
        restaurantService.deleteRestaurantById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
