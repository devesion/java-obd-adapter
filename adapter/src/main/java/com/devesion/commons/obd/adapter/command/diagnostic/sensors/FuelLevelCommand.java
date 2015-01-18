package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;

/**
 * Reads current fuel level percentage.
 */
public class FuelLevelCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.FUEL_LEVEL;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createFuelLevelValue(getResult());
	}
}
