package com.autonalyzer.adapter.android.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class DiagnosticStatus {

	@Setter
	@Getter
	private int runtime;

	@Setter
	@Getter
	private int speed;

	@Setter
	@Getter
	private int rpm;

	@Setter
	@Getter
	private float throttlePosition;

	@Setter
	@Getter
	private double massAirFlow;

	@Setter
	@Getter
	private int load;

	@Setter
	@Getter
	private int fuelLevel;

	@Setter
	@Getter
	private int fuelPressure;

	@Setter
	@Getter
	private int fuelType;

	@Setter
	@Getter
	private double ambientTemperature;

	@Setter
	@Getter
	private double coolantTemperature;

	@Setter
	@Getter
	private double intakeAirTemperature;
}
