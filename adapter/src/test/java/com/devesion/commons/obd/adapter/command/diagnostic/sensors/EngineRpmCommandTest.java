package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.UnitFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class EngineRpmCommandTest extends BaseSensorCommandTest {

	private EngineRpmCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);

		sut = new EngineRpmCommand();
		UnitFactory unitFactoryMock = recordUnitFactoryCreatesRpm();
		sut.setUnitFactory(unitFactoryMock);
	}

	@Test
	public void getPidShouldReturnObdPidForSensor() throws Exception {
		testCommandReturnsProperPid(sut, SensorCommandPid.ENGINE_RPM);
	}

	@Test
	public void getValueShouldCreateRpmValueObjectFromResultBuffer() throws Exception {
		testCommandGetValueCreateProperValueObject(sut);
	}
}