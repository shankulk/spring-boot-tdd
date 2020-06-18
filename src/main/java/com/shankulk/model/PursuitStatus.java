package com.shankulk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@JsonFormat(shape = Shape.STRING)
@JsonSerialize(using = StringSerializer.class)
@JsonDeserialize(using = StringDeserializer.class)
public enum PursuitStatus {

    COMPLETED,
    CREATED,
    EXPIRED
}
