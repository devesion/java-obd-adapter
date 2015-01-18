package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;

/**
 * Represents Temperature Value Object.
 */
class TemperatureValue extends AbstractSensorCommandValue {

	TemperatureValue(CommandResult commandResult) {
		super(commandResult);
	}

	@Override
	protected float calculateValue() {
		int majorByte = getResultByteNumber(0);
		return majorByte - 40;
	}
}
