package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.UnitFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class AmbientAirTemperatureCommandTest extends BaseSensorCommandTest {

	private AmbientAirTemperatureCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);

		sut = new AmbientAirTemperatureCommand();
		UnitFactory unitFactoryMock = recordUnitFactoryCreatesTemperature();
		sut.setUnitFactory(unitFactoryMock);
	}

	@Test
	public void getPidShouldReturnObdPidForSensor() throws Exception {
		testCommandReturnsProperPid(sut, SensorCommandPid.AMBIENT_AIR_TEMPERATURE);
	}

	@Test
	public void getValueShouldCreateTemperatureValueObjectFromResultBuffer() throws Exception {
		testCommandGetValueCreateProperValueObject(sut);
	}
}