package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.UnitFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class EngineRuntimeCommandTest extends BaseSensorCommandTest {

	private EngineRuntimeCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);

		sut = new EngineRuntimeCommand();
		UnitFactory unitFactoryMock = recordUnitFactoryCreatesTime();
		sut.setUnitFactory(unitFactoryMock);
	}

	@Test
	public void getPidShouldReturnObdPidForSensor() throws Exception {
		testCommandReturnsProperPid(sut, SensorCommandPid.ENGINE_RUN_TIME);
	}

	@Test
	public void getValueShouldCreateTimeValueObjectFromResultBuffer() throws Exception {
		testCommandGetValueCreateProperValueObject(sut);
	}
}