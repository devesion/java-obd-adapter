package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.command.diagnostic.sensors.units.TemperatureValue;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Reads current engine coolant temperature.
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class EngineCoolantTemperatureCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPids.ENGINE_COOLANT_TEMPERATURE;
	}

	@Override
	public SensorCommandValue getValue() {
		return new TemperatureValue(getResult());
	}
}
