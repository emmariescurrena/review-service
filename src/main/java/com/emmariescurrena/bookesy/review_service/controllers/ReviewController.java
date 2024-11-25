package com.emmariescurrena.bookesy.review_service.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emmariescurrena.bookesy.review_service.dtos.ReviewDto;
import com.emmariescurrena.bookesy.review_service.models.Review;
import com.emmariescurrena.bookesy.review_service.services.ReviewService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    
    @Autowired
    ReviewService reviewService;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<Review> upsertReview(
        @Valid @RequestBody ReviewDto reviewDto
    ) {
        return reviewService.upsertReview(reviewDto);
    }

    @GetMapping("/review-id/{reviewId}")
    public Mono<Optional<Review>> getReviewByReviewId(@PathVariable Long reviewId) {
        return reviewService.getReviewById(reviewId);
    }
    

}
