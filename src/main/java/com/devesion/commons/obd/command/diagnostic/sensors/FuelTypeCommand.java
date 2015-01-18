package com.devesion.commons.obd.command.diagnostic.sensors;

import com.devesion.commons.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.shared.ObdNumberedEnum;

/**
 * Reads current fuel type.
 */
public class FuelTypeCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.FUEL_TYPE;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createFuelTypeValue(getResult());
	}
}
