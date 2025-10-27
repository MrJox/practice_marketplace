package com.marketplace.dto;

import com.marketplace.entity.ProductAvailabilityStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductFilterDto(
    LocalDateTime dateFrom,
    LocalDateTime dateTo,
    BigDecimal priceFrom,
    BigDecimal priceTo,
    ProductAvailabilityStatus status
) {}
