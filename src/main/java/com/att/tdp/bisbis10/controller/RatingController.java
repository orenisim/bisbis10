package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.NewRatingDto;
import com.att.tdp.bisbis10.model.Rating;
import com.att.tdp.bisbis10.service.RatingService;
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

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Void> addRating(@RequestBody NewRatingDto newRating) {
        ratingService.addRating(newRating);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
