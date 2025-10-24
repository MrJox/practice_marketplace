package com.marketplace.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductDto(
        @NotBlank(message = "Name should not be empty.")
        @Size(min=2, max = 255, message = "Name should be between 2 and 255 characters")
        String name,

        @Positive(message = "Price should be non-negative.")
        BigDecimal price
) {}
