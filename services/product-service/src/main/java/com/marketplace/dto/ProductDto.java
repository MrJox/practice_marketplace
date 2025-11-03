package com.marketplace.dto;

import com.marketplace.entity.ProductAvailabilityStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductDto(
        Long id,

        @NotBlank(message = "Product Name should not be empty.")
        @Size(min = 2, max = 255, message = "Name should be between 2 and 255 characters")
        String name,

        @NotBlank(message = "Product Description should not be empty.")
        @Size(min = 2, max = 255, message = "Description should be between 2 and 255 characters")
        String description,

        @Positive(message = "Price should be non-negative.")
        BigDecimal price,

        ProductAvailabilityStatus status
) {}
