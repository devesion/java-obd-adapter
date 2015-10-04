package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class SimpleValue extends AbstractSensorCommandValue {

	private static final int DEFAULT_MULTIPLIER = 256;
	private final float multiplier;
	private final float divisor;

	SimpleValue(CommandResult commandResult, float divisor) {
		super(commandResult);
		this.multiplier = DEFAULT_MULTIPLIER;
		this.divisor = divisor;
	}

	SimpleValue(CommandResult commandResult, float multiplier, float divisor) {
		super(commandResult);
		this.multiplier = multiplier;
		this.divisor = divisor;
	}

	@Override
	protected float calculateValue() {
		int majorByte = getResultByteNumber(0);
		int minorByte = getResultByteNumber(1);
		return (majorByte * multiplier + minorByte) / divisor;
	}
}
