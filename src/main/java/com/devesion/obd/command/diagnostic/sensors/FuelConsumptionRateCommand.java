package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.FuelConsumptionValue;
import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Reads current fuel consumption rate.
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FuelConsumptionRateCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPids.FUEL_CONSUMPTION_1;
	}

	@Override
	public SensorCommandValue getValue() {
		return new FuelConsumptionValue(getResult());
	}
}
