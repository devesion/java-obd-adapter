package com.devesion.commons.obd.command.diagnostic.sensors;

import com.devesion.commons.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.shared.ObdNumberedEnum;

/**
 * Reads current Throttle Position Percentage.
 */
public class ThrottlePositionCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.THROTTLE_POSITION_PERCENTAGE;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createPercentageValue(getResult());
	}
}
