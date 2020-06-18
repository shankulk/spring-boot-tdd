package com.shankulk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.STRING)
public enum ObjectiveComparator {

	GT(">"), LT("<"), EQ("="), LTE("<="), GTE(">=");

	private String name;

	ObjectiveComparator(String name) {
		this.name = name;
	}
	
}
