package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.invoker.CommandResult;

/**
 * Represents Fuel Consumption Value Object.
 */
public class FuelConsumptionValue extends SimpleValue {

	private static final float FUEL_CONSUMPTION_DIVISOR = 20f;

	public FuelConsumptionValue(CommandResult commandResult) {
		super(commandResult, FUEL_CONSUMPTION_DIVISOR);
	}
}
