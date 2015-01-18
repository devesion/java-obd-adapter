package com.devesion.commons.obd.adapter.command.diagnostic.sensors.units;

import com.devesion.commons.obd.adapter.command.CommandResult;
import org.mockito.Mock;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

abstract class BaseValueTest {

	@Mock
	private CommandResult commandResultMock;

	protected void constructorShouldSetDefaultDivisorAndMultiplier(float multiplier, float divisor) throws Exception {
		// given
		when(commandResultMock.getByteNumber(0)).thenReturn(1);
		when(commandResultMock.getByteNumber(1)).thenReturn(0);
		float expectedValue = multiplier / divisor;

		// when
		AbstractSensorCommandValue sut = createSut(commandResultMock);
		float value = sut.calculateValue();

		// then
		assertThat(value).isEqualTo(expectedValue);
	}

	protected abstract AbstractSensorCommandValue createSut(CommandResult commandResultMock);
}