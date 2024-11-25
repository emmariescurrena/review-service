package com.emmariescurrena.bookesy.review_service.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emmariescurrena.bookesy.review_service.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findByUserId(Long userId);
    List<Review> findByBookId(String bookId);
    Optional<Review> findByBookIdAndUserId(String bookId, Long userId);
}
