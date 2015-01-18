package com.devesion.commons.obd.command.invoker;

import com.devesion.commons.obd.command.CommandResult;
import com.devesion.commons.obd.command.ObdCommand;
import com.devesion.commons.obd.link.CommandMarshaller;
import com.devesion.commons.obd.link.CommandUnmarshaller;
import com.devesion.commons.obd.link.ObdLink;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;

import static org.mockito.MockitoAnnotations.initMocks;

public class CommandInvokerTest {

	@Mock
	private ObdLink obdLinkMock;

	@Mock
	private CommandMarshaller commandMarshallerMock;

	@Mock
	private CommandUnmarshaller commandUnmarshallerMock;

	@Mock
	private ObdCommand obdCommandMock;

	@Mock
	private CommandResult commandResultMock;

	private CommandInvoker sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
	}
}