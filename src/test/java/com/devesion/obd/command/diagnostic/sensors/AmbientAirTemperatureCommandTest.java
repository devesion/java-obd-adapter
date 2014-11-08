package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.TestSupport;
import com.devesion.obd.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.obd.command.invoker.CommandResult;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AmbientAirTemperatureCommandTest extends BaseSensorCommandTest {

	@Mock
	private CommandResult commandResultMock;

	private AmbientAirTemperatureCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		sut = new AmbientAirTemperatureCommand();
	}

	@Test
	public void getPidShouldReturnObdPidForSensor() throws Exception {
		testCommandHasProperPid(sut, SensorCommandPids.AMBIENT_AIR_TEMPERATURE);
	}

	@Test
	public void getValueShouldCreateTemperatureValueObjectWithResultBuffer() throws Exception {
		// given
		int minorByte = TestSupport.getRandomInt(100);
		int expectedValue = minorByte - 40;
		when(commandResultMock.getByteNumber(0)).thenReturn(minorByte);
		sut.setResult(commandResultMock);

		// when
		SensorCommandValue value = sut.getValue();

		// then
		assertThat(value.getIntValue()).isEqualTo(expectedValue);
	}
}