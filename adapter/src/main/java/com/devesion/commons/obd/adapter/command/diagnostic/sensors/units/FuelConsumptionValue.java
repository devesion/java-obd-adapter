package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;

/**
 * Represents Fuel Consumption Value Object.
 */
class FuelConsumptionValue extends SimpleValue {

	private static final float FUEL_CONSUMPTION_DIVISOR = 20f;

	FuelConsumptionValue(CommandResult commandResult) {
		super(commandResult, FUEL_CONSUMPTION_DIVISOR);
	}
}
