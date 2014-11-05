package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.invoker.CommandResult;

/**
 * Represents Temperature Value Object.
 */
public class TemperatureValue extends AbstractSensorCommandValue {

	public TemperatureValue(CommandResult commandResult) {
		super(commandResult);
	}

	@Override
	protected float calculateValue() {
		int majorByte = getResultByteNumber(0);
		return majorByte - 40;
	}
}
