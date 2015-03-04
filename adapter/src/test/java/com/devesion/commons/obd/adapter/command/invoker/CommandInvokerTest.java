package com.devesion.commons.obd.adapter.command.invoker;

import com.devesion.commons.obd.adapter.command.CommandResult;
import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.link.CommandMarshaller;
import com.devesion.commons.obd.adapter.link.CommandUnmarshaller;
import com.devesion.commons.obd.adapter.link.ObdLink;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;

import static org.mockito.MockitoAnnotations.initMocks;

// TODO
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