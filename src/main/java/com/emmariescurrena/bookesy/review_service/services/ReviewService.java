package com.emmariescurrena.bookesy.review_service.services;

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

        return reviewRepository.findByBookIdAndUserId(reviewDto.getBookId(), reviewDto.getUserId())
            .switchIfEmpty(Mono.defer(() -> {
                Review review = new Review();
                BeanUtils.copyProperties(reviewDto, review);
                return reviewRepository.save(review);
            }));

    }

    public Mono<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public Flux<Review> getReviewsByBookId(String bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    public Flux<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
    
    public Mono<Review> getReviewByBookIdAndUserId(String bookId, Long userId) {
        return reviewRepository.findByBookIdAndUserId(bookId, userId);
    }

}
