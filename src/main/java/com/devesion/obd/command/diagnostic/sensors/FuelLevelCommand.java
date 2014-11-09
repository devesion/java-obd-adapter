package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;

/**
 * Reads current fuel level percentage.
 */
public class FuelLevelCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPids.FUEL_LEVEL;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createFuelLevelValue(getResult());
	}
}
