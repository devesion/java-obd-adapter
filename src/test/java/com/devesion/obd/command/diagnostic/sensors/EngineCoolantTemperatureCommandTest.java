package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.command.diagnostic.sensors.units.UnitFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class EngineCoolantTemperatureCommandTest extends BaseSensorCommandTest {

	private EngineCoolantTemperatureCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);

		sut = new EngineCoolantTemperatureCommand();
		UnitFactory unitFactoryMock = recordUnitFactoryCreatesTemperature();
		sut.setUnitFactory(unitFactoryMock);
	}

	@Test
	public void getPidShouldReturnObdPidForSensor() throws Exception {
		testCommandReturnsProperPid(sut, SensorCommandPids.ENGINE_COOLANT_TEMPERATURE);
	}

	@Test
	public void getValueShouldCreateTemperatureValueObjectFromResultBuffer() throws Exception {
		testCommandGetValueCreateProperValueObject(sut);
	}
}