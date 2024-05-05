package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.DishDto;
import com.att.tdp.bisbis10.dto.NewDishDto;
import com.att.tdp.bisbis10.service.DishService;
import com.att.tdp.bisbis10.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants/{id}/dishes")
public class DishController {

    private static final Logger logger = LoggerFactory.getLogger(DishController.class);

    @Autowired
    private DishService dishService;

    @Autowired
    private ValidationService validationService;

    @PostMapping
    public ResponseEntity<Void> addDishToRestaurantById(@PathVariable long id, @RequestBody NewDishDto newDish) {
        try {
            logger.info("Adding new dish to restaurant with ID {}: {}", id, newDish);
            validationService.validateNewDish(newDish);
            dishService.addDishToRestaurantById(id, newDish);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Failed to add new dish: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<Void> updateDishById(@PathVariable long id, @PathVariable long dishId, @RequestBody NewDishDto updateDish) {
        try {
            logger.info("Updating dish with ID {} for restaurant with ID {}: {}", dishId, id, updateDish);
            validationService.validateUpdatedDish(updateDish);
            dishService.updateDishById(id, dishId, updateDish);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to update dish: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{dishId}")
    public ResponseEntity<Void> deleteDishById(@PathVariable long id, @PathVariable long dishId) {
        try {
            logger.info("Deleting dish with ID {} for restaurant with ID {}", dishId, id);
            dishService.deleteDishById(id, dishId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Failed to delete dish: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<DishDto>> getDishesByRestaurantId(@PathVariable long id) {
        try {
            logger.info("Fetching dishes for restaurant with ID {}", id);
            List<DishDto> dishes = dishService.getDishesByRestaurantId(id);
            return new ResponseEntity<>(dishes, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to fetch dishes: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
