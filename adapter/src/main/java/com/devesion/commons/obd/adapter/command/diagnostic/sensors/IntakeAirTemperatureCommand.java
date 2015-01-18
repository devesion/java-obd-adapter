package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;

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
