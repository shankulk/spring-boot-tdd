package com.shankulk.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.UUID;

public class Pursuit {

    private final PursuitStatus status;
    private final Objective objective;
    private final UUID id;

    private Pursuit(UUID id, PursuitStatus status, Objective objective) {
        this.id = id;
        this.status = status;
        this.objective = objective;
    }

    public static Pursuit createPursuit(Objective objective) {
        return new Pursuit(UUID.randomUUID(), PursuitStatus.CREATED, objective);
    }

    public UUID getId() {
        return id;
    }

    @JsonValue
    public PursuitStatus getStatus() {
        return status;
    }

	public Objective getObjective() {
		return objective;
	}
}
