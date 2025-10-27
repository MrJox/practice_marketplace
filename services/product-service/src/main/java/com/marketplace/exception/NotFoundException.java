package com.marketplace.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final String missingEntityName;
    private final Long entityId;

    public NotFoundException(String name, Long id) {
        super(String.format("Entity [%s] with (id: %s) not found.", name, id));

        this.missingEntityName = name;
        this.entityId = id;
    }
}
