package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;

/**
 * Reads current fuel type.
 */
@EqualsAndHashCode(callSuper = true)
public class FuelTypeCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPids.FUEL_TYPE;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createFuelTypeValue(getResult());
	}
}
