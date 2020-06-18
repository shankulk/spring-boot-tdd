package com.shankulk.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.UUID;

public class Objective {
	private final UUID id;
	private final String metricName;
	private final ObjectiveComparator comparator;
	private final Double metricValve;
	private final String objectiveName;

	private Objective(String metricName, ObjectiveComparator comparator, Double metricValue,
		String objectiveName) {
		this.id = UUID.randomUUID();
		this.metricName = metricName;
		this.comparator = comparator;
		this.metricValve = metricValue;
		this.objectiveName = objectiveName;
	}

	public UUID getId() {
		return id;
	}

	public String getMetricName() {
		return metricName;
	}

	@JsonValue
	public ObjectiveComparator getComparator() {
		return comparator;
	}

	public Double getMetricValve() {
		return metricValve;
	}

	public static Objective createObjective(String objectiveName, String metricName, ObjectiveComparator comparator, Double metricValue) {
		return new Objective(metricName, comparator, metricValue, objectiveName);
	}

}
