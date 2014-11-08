package com.devesion.obd.command.invoker;

import com.devesion.obd.TestSupport;
import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.command.invoker.marshaller.CommandMarshaller;
import com.devesion.obd.command.invoker.marshaller.CommandUnmarshaller;
import com.devesion.obd.link.ObdLink;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
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
		sut = new CommandInvoker(obdLinkMock, commandMarshallerMock, commandUnmarshallerMock);

		String commandData = TestSupport.getRandomString();
		String commandResponseData = TestSupport.getRandomString();

		when(obdLinkMock.sendDataAndReadResponse(commandData)).thenReturn(commandResponseData);
		when(commandMarshallerMock.marshal(obdCommandMock)).thenReturn(commandData);
		when(commandUnmarshallerMock.unmarshal(obdCommandMock, commandResponseData)).thenReturn(commandResultMock);
	}

	@Test
	public void constructorShouldSetDefaultBridges() throws Exception {
		// given

		// when
		sut = new CommandInvoker(obdLinkMock);

		// then
		CommandMarshaller commandMarshaller = sut.getCommandMarshaller();
		CommandUnmarshaller commandUnmarshaller = sut.getCommandUnmarshaller();
		assertThat(commandMarshaller).isNotNull();
		assertThat(commandUnmarshaller).isNotNull();
	}

	@Test
	public void invokeShouldMarshalCommandAndUnmarshalResponse() throws Exception {
		// given

		// when
		sut.invoke(obdCommandMock);

		// then
		verify(obdCommandMock).setResult(commandResultMock);
		verifyNoMoreInteractions(obdCommandMock);
	}
}