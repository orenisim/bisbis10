package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.DishDto;
import com.att.tdp.bisbis10.dto.NewDishDto;
import com.att.tdp.bisbis10.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants/{id}/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    public ResponseEntity<Void> addDishToRestaurantById(@PathVariable long  id , @RequestBody NewDishDto newDish) {
        dishService.addDishToRestaurantById(id, newDish);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<Void> updateDishById(@PathVariable long id, @PathVariable long dishId, @RequestBody NewDishDto updateDish) {
        //needs to validate the dish by the restaurant ?? --> to use the restaurantID
        dishService.updateDishById(id, dishId, updateDish);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{dishId}")
    public ResponseEntity<Void> deleteDishById(@PathVariable long id, @PathVariable long dishId) {
        dishService.deleteDishById(id, dishId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<DishDto>> getDishesByRestaurantId(@PathVariable long id) {
        List<DishDto> dishes = dishService.getDishesByRestaurantId(id);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }


}
