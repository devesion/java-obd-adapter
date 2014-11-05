package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.invoker.CommandResult;

/**
 *
 */
public class SimpleValue extends AbstractSensorCommandValue {

	private float divisor;

	public SimpleValue(CommandResult commandResult, float divisor) {
		super(commandResult);
		this.divisor = divisor;
	}

	@Override
	protected float calculateValue() {
		int majorByte = getResultByteNumber(0);
		int minorByte = getResultByteNumber(1);
		return ((majorByte * 256 + minorByte) / divisor);
	}
}
