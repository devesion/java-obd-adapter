package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;

/**
 * Reads current fuel consumption rate.
 */
public class FuelConsumptionRateCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.FUEL_CONSUMPTION_1;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createFuelConsumptionValue(getResult());
	}
}
