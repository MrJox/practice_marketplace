package com.marketplace;

import java.time.Instant;

public final class EventEnvelope<T extends IDomainEvent> {
    private final String eventId;
    private final Instant timestamp;
    private final T payload;

    public EventEnvelope(String eventId, Instant timestamp, T payload) {
        this.eventId = eventId;
        this.timestamp = timestamp;
        this.payload = payload;
    }

    public String getEventId() {
        return eventId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public T getPayload() {
        return payload;
    }
}
