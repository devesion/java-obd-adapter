package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;

/**
 * Reads current Vehicle Speed value.
 */
public class SpeedCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPid.VEHICLE_SPEED;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createSpeedValue(getResult());
	}
}
