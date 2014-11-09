package com.devesion.obd.shared;

import com.devesion.obd.command.ObdCommand;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.initMocks;

public class ObdCommandResponseExceptionTest extends BaseObdCommandResponseExceptionTest {

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
	}

	@Test
	public void constructorShouldSetCommand() throws Exception {
		testConstructorShouldSetCommand();
	}

	@Override
	protected ObdCommandResponseException createException(ObdCommand obdCommandMock) {
		return new ObdCommandResponseException(obdCommandMock);
	}
}