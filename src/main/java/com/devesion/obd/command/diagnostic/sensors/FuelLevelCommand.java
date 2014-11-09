package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Reads current fuel level percentage.
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
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
