package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.PercentageValue;
import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Reads current Throttle Position Percentage.
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ThrottlePositionCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPids.THROTTLE_POSITION_PERCENTAGE;
	}

	@Override
	public SensorCommandValue getValue() {
		return new PercentageValue(getResult());
	}
}
