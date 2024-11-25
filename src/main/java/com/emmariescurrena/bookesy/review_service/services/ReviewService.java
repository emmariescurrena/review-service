package com.emmariescurrena.bookesy.review_service.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmariescurrena.bookesy.review_service.dtos.ReviewDto;
import com.emmariescurrena.bookesy.review_service.models.Review;
import com.emmariescurrena.bookesy.review_service.repositories.ReviewRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public Mono<Review> upsertReview(ReviewDto reviewDto) {

        Review review = reviewRepository
                .findByBookIdAndUserId(reviewDto.getBookId(), reviewDto.getUserId())
                .orElse(null);
                
        if (review == null) {
            review = new Review();
        }

        BeanUtils.copyProperties(reviewDto, review);

        return Mono.just(reviewRepository.save(review));

    }

    public Mono<Optional<Review>> getReviewById(Long reviewId) {
        return Mono.just(reviewRepository.findById(reviewId));
    }

    public Flux<Review> getReviewsByBookId(String bookId) {
        return Flux.defer(() -> Flux.fromIterable(reviewRepository.findByBookId(bookId)));
    }

    public Flux<Review> getReviewsByUserId(Long userId) {
        return Flux.defer(() -> Flux.fromIterable(reviewRepository.findByUserId(userId)));
    }
    
    public Mono<Optional<Review>> getReviewByBookIdAndUserId(String bookId, Long userId) {
        return Mono.just(reviewRepository.findByBookIdAndUserId(bookId, userId));
    }

}
