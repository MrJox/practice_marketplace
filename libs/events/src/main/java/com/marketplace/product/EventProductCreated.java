package com.marketplace.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marketplace.IDomainEvent;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public final class EventProductCreated implements IDomainEvent {
    private final UUID productId;
    private final String name;
    private final BigDecimal price;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private final Instant createdAt;

    public EventProductCreated(UUID uuid, String name, BigDecimal price, Instant createdAt) {
        this.productId = uuid;
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
