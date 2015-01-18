package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;

/**
 * Reads current ambient air temperature.
 */
public class AmbientAirTemperatureCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.AMBIENT_AIR_TEMPERATURE;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createTemperatureValue(getResult());
	}
}
