package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;

/**
 * Reads current intake air temperature.
 */
public class IntakeAirTemperatureCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.INTAKE_AIR_TEMPERATURE;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createTemperatureValue(getResult());
	}
}
