package com.shankulk.model;

import java.util.UUID;

public class Pursuit {

    private final PursuitStatus status;
    private final UUID id;

    private Pursuit(UUID id, PursuitStatus status) {
        this.id = id;
        this.status = status;
    }

    public static Pursuit createPursuit() {
        return new Pursuit(UUID.randomUUID(), PursuitStatus.CREATED);
    }

    public UUID getId() {
        return id;
    }

    public PursuitStatus getStatus() {
        return status;
    }
}
