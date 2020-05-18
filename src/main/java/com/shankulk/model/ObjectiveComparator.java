package com.shankulk.model;

public enum ObjectiveComparator {

	GT(">"), LT("<"), EQ("="), LTE("<="), GTE(">=");

	private String name;

	ObjectiveComparator(String name) {
		this.name = name;
	}
	
}
