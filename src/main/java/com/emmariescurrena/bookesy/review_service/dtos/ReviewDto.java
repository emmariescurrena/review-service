package com.emmariescurrena.bookesy.review_service.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReviewDto {

    @NotNull(message = "The user id is required")
    private Long userId;

    @NotEmpty(message = "The book id is required")
    private String bookId;

    @Size(min = 50, max = 5000, message = "The length of text must be between 50 and 5000 characters")
    private String text;

    @Min(value = 1, message = "The rating must be equal or higher than 1")
    @Max(value = 10, message = "The rating must be equal or lower than 10")
    private Integer rating;

}
