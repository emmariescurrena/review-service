package com.emmariescurrena.bookesy.review_service.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table("reviews")
public class Review {
    
    @Id
    private Long id;

    @Column("user_id")
    @NotNull(message = "The user id is required")
    private Long userId;

    @Column("book_id")
    @NotEmpty(message = "The book id is required")
    private String bookId;

    @Column("text")
    @Size(min = 50, max = 5000, message = "The length of text must be between 50 and 5000 characters")
    private String text;

    @Column("rating")
    @Min(value = 1, message = "The rating must be equal or higher than 1")
    @Max(value = 10, message = "The rating must be equal or lower than 10")
    private Integer rating;

    @Column("creation_date")
    @CreatedDate
    private LocalDateTime creationDate;

}
