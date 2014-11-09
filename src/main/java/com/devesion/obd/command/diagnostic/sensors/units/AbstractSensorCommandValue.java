package com.devesion.obd.command.diagnostic.sensors.units;

import com.devesion.obd.command.CommandResult;
import lombok.AccessLevel;
import lombok.Getter;

abstract class AbstractSensorCommandValue implements SensorCommandValue {

	@Getter(AccessLevel.PACKAGE)
	private CommandResult commandResult;

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
