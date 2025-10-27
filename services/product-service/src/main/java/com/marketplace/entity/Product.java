package com.marketplace.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long productId;

    private String name;

    private String description;

    private BigDecimal price;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private ProductAvailabilityStatus status;
}
