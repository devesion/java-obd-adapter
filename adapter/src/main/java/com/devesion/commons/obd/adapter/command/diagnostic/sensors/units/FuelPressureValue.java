package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;

/**
 * Represents Fuel pressure Value Object.
 */
class FuelPressureValue extends PressureValue {

	FuelPressureValue(CommandResult commandResult) {
		super(commandResult);
	}

	@Override
	protected float calculateValue() {
		int majorByte = getResultByteNumber(0);
		return majorByte * 3;
	}
}
