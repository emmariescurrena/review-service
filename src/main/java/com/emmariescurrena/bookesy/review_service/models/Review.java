package com.emmariescurrena.bookesy.review_service.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "REVIEWS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"userId", "bookId"})
})
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "The user id is required")
    private Long userId;

    @Column(nullable = false)
    @NotEmpty(message = "The book id is required")
    private String bookId;

    @Column(nullable = false)
    @Size(min = 50, max = 5000, message = "The length of text must be between 50 and 5000 characters")
    private String text;

    @Column(nullable = false)
    @Min(value = 1, message = "The rating must be equal or higher than 1")
    @Max(value = 10, message = "The rating must be equal or lower than 10")
    private Integer rating;

    @Column(name = "creation_date", updatable = false)
    @CreationTimestamp
    private Date creationDate;

}
