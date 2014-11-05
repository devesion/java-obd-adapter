package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.DiagnosticCommandPid;
import lombok.Getter;

/**
 * Popular diagnostic command sensor's PIDs - OBD Mode 1.
 */
public enum SensorCommandPids implements DiagnosticCommandPid {
	PIDS_SUPPORTED_SET_1(0),
	OVERALL_STATUS(1),
	FUEL_SYSTEM_STATUS(3),
	ENGINE_LOAD(4),
	ENGINE_COOLANT_TEMPERATURE(5),
	SHORT_TERM_FUEL_BANK1(6),
	LONG_TERM_FUEL_BANK1(7),
	SHORT_TERM_FUEL_BANK2(8),
	LONG_TERM_FUEL_BANK2(9),
	FUEL_PRESSURE(10),
	INTAKE_MANIFOLD_PRESSURE(11),
	ENGINE_RPM(12),
	VEHICLE_SPEED(13),
	INTAKE_AIR_TEMPERATURE(15),
	MASS_AIR_FLOW(16),
	THROTTLE_POSITION_PERCENTAGE(17),
	ENGINE_RUN_TIME(31),
	PIDS_SUPPORTED_SET_2(32),
	FUEL_LEVEL(47),
	BAROMETRIC_PRESSURE(51),
	AMBIENT_AIR_TEMPERATURE(70),
	FUEL_CONSUMPTION_1(94),
	FUEL_CONSUMPTION_2(95),
	ENGINE_TORQUE_NM(99),
	ENGINE_TORQUE_PERCENTAGE(100),
	TURBOCHARGER_PRESSURE(111),
	EXHAUST_PRESSURE(115);

	@Getter
	private int number;

	SensorCommandPids(int number) {
		this.number = number;
	}
}
