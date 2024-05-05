package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.NewRatingDto;
import com.att.tdp.bisbis10.model.Rating;
import com.att.tdp.bisbis10.service.RatingService;
import com.att.tdp.bisbis10.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private static final Logger logger =  LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RatingService ratingService;

    @Autowired
    private ValidationService validationService;

    @PostMapping
    public ResponseEntity<Void> addRating(@RequestBody NewRatingDto newRating) {
        logger.info("Adding new rating" + newRating);
        try{
            validationService.validateNewRating(newRating);
            ratingService.addRating(newRating);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            logger.error("An unexpected error occurred while adding rating: {}" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
