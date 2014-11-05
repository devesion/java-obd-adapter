package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.AbstractDiagnosticCommand;
import com.devesion.obd.command.diagnostic.DiagnosticCommandMode;
import com.devesion.obd.shared.ObdNumberedEnum;

/**
 *
 */
abstract class AbstractSensorCommand extends AbstractDiagnosticCommand implements SensorCommand {

	@Override
	public ObdNumberedEnum getMode() {
		return DiagnosticCommandMode.SENSORS;
	}
}
