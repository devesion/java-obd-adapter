package com.devesion.commons.obd.adapter.link.elm;

import com.devesion.commons.obd.TestSupport;
import com.devesion.commons.obd.adapter.command.CommandResult;
import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.link.CommandMarshaller;
import com.devesion.commons.obd.adapter.link.CommandUnmarshaller;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ElmLinkTest {

	@Mock
	private ElmTransport elmTransportMock;

	@Mock
	private CommandMarshaller commandMarshallerMock;

	@Mock
	private CommandUnmarshaller commandUnmarshallerMock;

	@Mock
	private ObdCommand obdCommandMock;

	@Mock
	private CommandResult commandResultMock;

	private ElmLink sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		sut = new ElmLink(elmTransportMock, commandMarshallerMock, commandUnmarshallerMock);

		String commandData = TestSupport.getRandomString();
		String commandResponseData = TestSupport.getRandomString();

		when(elmTransportMock.sendDataAndReadResponse(commandData)).thenReturn(commandResponseData);
		when(commandMarshallerMock.marshal(obdCommandMock)).thenReturn(commandData);
		when(commandUnmarshallerMock.unmarshal(obdCommandMock, commandResponseData)).thenReturn(commandResultMock);
	}

	@Test
	public void constructorShouldSetDefaultMarshallers() throws Exception {
		// given

		// when
		sut = new ElmLink(elmTransportMock);

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
		CommandResult commandResult = sut.sendCommand(obdCommandMock);

		// then
		assertThat(commandResult).isEqualTo(commandResultMock);
	}
}