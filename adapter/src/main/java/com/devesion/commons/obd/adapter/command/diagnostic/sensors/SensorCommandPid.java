package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.DiagnosticCommandPid;
import lombok.Getter;

/**
 * Popular com.autonalyzer.adapter.android.infrastture.diagnostic command sensor's PIDs - OBD Mode 1.
 */
public enum SensorCommandPid implements DiagnosticCommandPid {
	PIDS_SUPPORTED_SET_1(0x00),
	OVERALL_STATUS(0x01),
	FUEL_SYSTEM_STATUS(0x03),
	ENGINE_LOAD(0x04),
	ENGINE_COOLANT_TEMPERATURE(0x05),
	SHORT_TERM_FUEL_BANK1(0x06),
	LONG_TERM_FUEL_BANK1(0x07),
	SHORT_TERM_FUEL_BANK2(0x08),
	LONG_TERM_FUEL_BANK2(0x09),
	FUEL_PRESSURE(0x0A),
	INTAKE_MANIFOLD_PRESSURE(0x0B),
	ENGINE_RPM(0x0C),
	VEHICLE_SPEED(0x0D),
	INTAKE_AIR_TEMPERATURE(0x0F),
	MASS_AIR_FLOW(0x10),
	THROTTLE_POSITION_PERCENTAGE(0x11),
	ENGINE_RUN_TIME(0x1F),
	PIDS_SUPPORTED_SET_2(0x20),
	FUEL_LEVEL(0x2F),
	BAROMETRIC_PRESSURE(0x33),
	AMBIENT_AIR_TEMPERATURE(0x46),
	FUEL_TYPE(0x51),
	FUEL_CONSUMPTION_1(0x5E),
	FUEL_CONSUMPTION_2(0x5F),
	ENGINE_TORQUE_NM(0x63),
	ENGINE_TORQUE_PERCENTAGE(0x64),
	TURBOCHARGER_PRESSURE(0x6F),
	EXHAUST_PRESSURE(0x73);

	@Getter
	private int number;

	SensorCommandPid(int number) {
		this.number = number;
	}
}
