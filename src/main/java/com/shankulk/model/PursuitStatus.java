package com.shankulk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.STRING)
public enum PursuitStatus {

    COMPLETED,
    CREATED,
    EXPIRED
}
