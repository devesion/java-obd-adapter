package com.devesion.obd.shared;

import com.devesion.obd.command.ObdCommand;
import org.mockito.Mock;

import static org.fest.assertions.api.Assertions.assertThat;

abstract class BaseObdCommandResponseExceptionTest {

	@Mock
	private ObdCommand obdCommandMock;

	protected void testConstructorShouldSetCommand() {
		// given

		// when
		ObdCommandResponseException sut = createException(obdCommandMock);

		// then
		assertThat(sut.getCommand()).isEqualTo(obdCommandMock);
	}

	protected abstract ObdCommandResponseException createException(ObdCommand obdCommandMock);
}
