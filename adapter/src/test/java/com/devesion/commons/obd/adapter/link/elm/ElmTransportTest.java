package com.devesion.commons.obd.adapter.link.elm;

import com.devesion.commons.obd.TestSupport;
import com.devesion.commons.obd.adapter.shared.ObdCommunicationException;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.devesion.commons.obd.TestSupport.InputStreamAnswer;
import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ElmTransportTest {

	@Mock
	private InputStream isMock;

	@Mock
	private OutputStream osMock;

	private ElmTransport sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		sut = new ElmTransport(isMock, osMock);
	}

	@Test
	public void readDataShouldReadInputStreamToTheElmPrompt() throws Exception {
		// given
		String expectedData = getRandomStreamData();
		String streamData = "   " + expectedData + ">";

		when(isMock.read()).thenAnswer(new InputStreamAnswer(streamData));

		// when
		String readData = sut.readData();

		// then
		assertThat(readData).isEqualTo(expectedData);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void readDataShouldWrapExceptionsWithRuntimeException() throws Exception {
		// given
		when(isMock.read()).thenThrow(IOException.class);

		// when
		catchException(sut).readData();

		// then
		Exception exception = caughtException();
		assertThat(exception).isExactlyInstanceOf(ObdCommunicationException.class);
	}

	@Test
	public void sendDataShouldWriteDataToTheOutputStream() throws Exception {
		// given
		String expectedData = getRandomStreamData();

		// when
		sut.sendData(expectedData);

		// then
		InOrder inOrder = inOrder(osMock);
		inOrder.verify(osMock).write(expectedData.getBytes());
		inOrder.verify(osMock).flush();
	}

	@Test
	@SuppressWarnings("unchecked")
	public void sendDataShouldWrapExceptionsDuringWriteWithRuntimeException() throws Exception {
		// given
		String expectedData = getRandomStreamData();
		doThrow(IOException.class).when(osMock).write(expectedData.getBytes());

		// when
		catchException(sut).sendData(expectedData);

		// then
		Exception exception = caughtException();
		assertThat(exception).isExactlyInstanceOf(ObdCommunicationException.class);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void sendDataShouldWrapExceptionsDuringFlushWithRuntimeException() throws Exception {
		// given
		String expectedData = getRandomStreamData();
		doThrow(IOException.class).when(osMock).flush();

		// when
		catchException(sut).sendData(expectedData);

		// then
		Exception exception = caughtException();
		assertThat(exception).isExactlyInstanceOf(ObdCommunicationException.class);
	}

	@Test
	public void testSendDataAndReadResponse() throws Exception {
		// given
		String expectedData = getRandomStreamData();
		String expectedResponseData = getRandomStreamData();
		String expectedResponseStreamData = "   " + expectedResponseData + ">";
		when(isMock.read()).thenAnswer(new InputStreamAnswer(expectedResponseStreamData));

		// when
		String readData = sut.sendDataAndReadResponse(expectedData);

		// then
		InOrder inOrder = inOrder(isMock, osMock);
		inOrder.verify(osMock).write(expectedData.getBytes());
		inOrder.verify(osMock).flush();
		inOrder.verify(isMock, atLeastOnce()).read();
		assertThat(readData).isEqualTo(expectedResponseData);
	}

	private String getRandomStreamData() {
		return TestSupport.getRandomString() + " " + TestSupport.getRandomString() + " " + TestSupport.getRandomString();
	}
}