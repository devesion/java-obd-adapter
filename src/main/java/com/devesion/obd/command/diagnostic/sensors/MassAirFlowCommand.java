package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.EqualsAndHashCode;

/**
 * Reads current MAF value.
 */
@EqualsAndHashCode(callSuper = true)
public class MassAirFlowCommand extends AbstractSensorCommand {

	@Override
	public ObdNumberedEnum getPid() {
		return SensorCommandPids.MASS_AIR_FLOW;
	}

	@Override
	public SensorCommandValue getValue() {
		return getUnitFactory().createAirFlowValue(getResult());
	}
}
