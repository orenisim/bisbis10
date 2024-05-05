package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.NewRatingDto;
import com.att.tdp.bisbis10.model.Rating;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.RatingRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addRating(NewRatingDto newRating) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(newRating.getRestaurantId());
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();

            // Create a new Rating entity
            Rating rating = new Rating();
            rating.setRestaurant(restaurant);
            rating.setRating(newRating.getRating());

            // Save the rating
            ratingRepository.save(rating);


        }


    }
}
