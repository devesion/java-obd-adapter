package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.CommandResult;
import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.command.diagnostic.sensors.units.UnitFactory;
import com.devesion.obd.shared.ObdNumberedEnum;
import org.mockito.Mock;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

abstract class BaseSensorCommandTest {

	@Mock
	private UnitFactory unitFactoryMock;

	@Mock
	private CommandResult commandResultMock;

	@Mock
	private SensorCommandValue sensorCommandValueMock;

	protected void testCommandReturnsProperPid(SensorCommand sut, SensorCommandPids pid) {
		// given

		// when
		ObdNumberedEnum mode = sut.getPid();

		// then
		assertThat(mode).isEqualTo(pid);
	}

	protected void testCommandGetValueCreateProperValueObject(SensorCommand sut) {
		// given
		sut.setResult(commandResultMock);

		// when
		SensorCommandValue value = sut.getValue();

		// then
		assertThat(value).isEqualTo(sensorCommandValueMock);
	}

	protected UnitFactory recordUnitFactoryCreatesTemperature() {
		when(unitFactoryMock.createTemperatureValue(commandResultMock)).thenReturn(sensorCommandValueMock);
		return unitFactoryMock;
	}

	protected UnitFactory recordUnitFactoryCreatesPercentage() {
		when(unitFactoryMock.createPercentageValue(commandResultMock)).thenReturn(sensorCommandValueMock);
		return unitFactoryMock;
	}

	protected UnitFactory recordUnitFactoryCreatesRpm() {
		when(unitFactoryMock.createRpmValue(commandResultMock)).thenReturn(sensorCommandValueMock);
		return unitFactoryMock;
	}
}
