package com.devesion.commons.obd.command.diagnostic.sensors;

import com.devesion.commons.obd.command.diagnostic.AbstractDiagnosticCommand;
import com.devesion.commons.obd.command.diagnostic.DiagnosticCommandMode;
import com.devesion.commons.obd.command.diagnostic.sensors.units.UnitFactory;
import com.devesion.commons.obd.shared.ObdNumberedEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString()
abstract class AbstractSensorCommand extends AbstractDiagnosticCommand implements SensorCommand {

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private UnitFactory unitFactory = new UnitFactory();

	@Override
	public ObdNumberedEnum getMode() {
		return DiagnosticCommandMode.SENSORS;
	}
}