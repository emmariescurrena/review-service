package com.emmariescurrena.bookesy.review_service.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.emmariescurrena.bookesy.review_service.models.Review;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReviewRepository extends ReactiveCrudRepository<Review, Long>{
    Flux<Review> findByUserId(Long userId);
    Flux<Review> findByBookId(String bookId);
    Mono<Review> findByBookIdAndUserId(String bookId, Long userId);
}
