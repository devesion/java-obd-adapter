package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.FuelTypeValue;
import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Reads current fuel type.
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FuelTypeCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPids.FUEL_TYPE;
	}

	@Override
	public SensorCommandValue getValue() {
		return new FuelTypeValue(getResult());
	}
}
