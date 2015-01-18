package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;

/**
 * Reads current engine coolant temperature.
 */
public class EngineCoolantTemperatureCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.ENGINE_COOLANT_TEMPERATURE;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createTemperatureValue(getResult());
	}
}
