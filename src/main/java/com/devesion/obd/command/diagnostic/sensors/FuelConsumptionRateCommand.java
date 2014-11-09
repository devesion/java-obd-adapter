package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;

/**
 * Reads current fuel consumption rate.
 */
@EqualsAndHashCode(callSuper = true)
public class FuelConsumptionRateCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPids.FUEL_CONSUMPTION_1;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createFuelConsumptionValue(getResult());
	}
}
