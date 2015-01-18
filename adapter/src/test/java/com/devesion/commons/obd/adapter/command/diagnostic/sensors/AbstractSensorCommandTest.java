package com.devesion.commons.obd.adapter.command.diagnostic.sensors;

import com.devesion.commons.obd.adapter.command.diagnostic.DiagnosticCommandMode;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.units.SensorCommandValue;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class AbstractSensorCommandTest {

	private AbstractSensorCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		sut = new FakeAbstractSensorCommand();
	}

	@Test
	public void getModeShouldReturnSensors() throws Exception {
		// given

		// when
		ObdNumberedEnum mode = sut.getMode();

		// then
		assertThat(mode).isEqualTo(DiagnosticCommandMode.SENSORS);
	}

	private static class FakeAbstractSensorCommand extends AbstractSensorCommand {

		@Override
		public SensorCommandValue getValue() {
			return null;
		}

		@Override
		public ObdNumberedEnum getPid() {
			return null;
		}
	}
}