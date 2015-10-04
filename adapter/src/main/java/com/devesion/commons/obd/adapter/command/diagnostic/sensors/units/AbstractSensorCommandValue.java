package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract class AbstractSensorCommandValue implements SensorCommandValue {

	@Getter(AccessLevel.PACKAGE)
	private CommandResult commandResult = CommandResult.empty();

	public AbstractSensorCommandValue(CommandResult commandResult) {
		this.commandResult = commandResult;
	}

	@Override
	public int getIntValue() {
		return (int) getFloatValue();
	}

	@Override
	public float getFloatValue() {
		return calculateValue();
	}

	protected int getResultByteNumber(int byteNumber) {
		return commandResult.getByteNumber(byteNumber);
	}

	protected abstract float calculateValue();

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AbstractSensorCommandValue{");
		sb.append("intValue=").append(getIntValue()).append(", ").append("floatValue=").append(getFloatValue()).append('}');
		return sb.toString();
	}
}
