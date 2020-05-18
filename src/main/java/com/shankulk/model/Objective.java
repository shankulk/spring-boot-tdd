package com.shankulk.model;

import java.util.UUID;

public class Objective {
	private final UUID id;
	private final String metricName;
	private final ObjectiveComparator comparator;
	private final Double metricValve;

	private Objective(String metricName, ObjectiveComparator comparator, Double metricValue) {
		this.id = UUID.randomUUID();
		this.metricName = metricName;
		this.comparator = comparator;
		this.metricValve = metricValue;
	}

	public UUID getId() {
		return id;
	}

	public String getMetricName() {
		return metricName;
	}

	public ObjectiveComparator getComparator() {
		return comparator;
	}

	public Double getMetricValve() {
		return metricValve;
	}

	public static Objective createObjective(String metricName, ObjectiveComparator comparator, Double metricValue) {
		return new Objective(metricName, comparator, metricValue);
	}

}
