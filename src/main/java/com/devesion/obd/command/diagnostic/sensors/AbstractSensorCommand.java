package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.AbstractDiagnosticCommand;
import com.devesion.obd.command.diagnostic.DiagnosticCommandMode;
import com.devesion.obd.command.diagnostic.sensors.units.UnitFactory;
import com.devesion.obd.shared.ObdNumberedEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

abstract class AbstractSensorCommand extends AbstractDiagnosticCommand implements SensorCommand {

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private UnitFactory unitFactory = new UnitFactory();

	@Override
	public ObdNumberedEnum getMode() {
		return DiagnosticCommandMode.SENSORS;
	}
}
