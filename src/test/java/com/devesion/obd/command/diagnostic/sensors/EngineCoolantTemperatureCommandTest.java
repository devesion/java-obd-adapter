package com.devesion.obd.command.diagnostic.sensors;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class EngineCoolantTemperatureCommandTest extends BaseSensorCommandTest {

	private EngineCoolantTemperatureCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		sut = new EngineCoolantTemperatureCommand();
	}

	@Test
	public void getPidShouldReturnObdPidForSensor() throws Exception {
		testCommandHasProperPid(sut, SensorCommandPids.ENGINE_COOLANT_TEMPERATURE);
	}
}