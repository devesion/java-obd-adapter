package com.devesion.obd.link;

import com.devesion.obd.TestSupport;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.io.OutputStream;

import static com.devesion.obd.TestSupport.InputStreamAnswer;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ObdLinkTest {

	@Mock
	private InputStream isMock;

	@Mock
	private OutputStream osMock;

	private ObdLink sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
	}

	@Test
	public void readDataShouldReadInputStreamToTheElmPrompt() throws Exception {
		// given
		String expectedData = getRandomStreamData();
		String streamData = "   " + expectedData + ">";

		when(isMock.read()).thenAnswer(new InputStreamAnswer(streamData));
		sut = new ObdLink(isMock, osMock);

		// when
		String readData = sut.readData();

		// then
		assertThat(readData).isEqualTo(expectedData);
	}

	@Test
	public void sendDataShouldWriteDataToTheOutputStream() throws Exception {
		// given
		String expectedData = getRandomStreamData();
		sut = new ObdLink(isMock, osMock);

		// when
		sut.sendData(expectedData);

		// then
		InOrder inOrder = inOrder(osMock);
		inOrder.verify(osMock).write(expectedData.getBytes());
		inOrder.verify(osMock).flush();
	}

	@Test
	public void testSendDataAndReadResponse() throws Exception {
		// given
		String expectedData = getRandomStreamData();
		String expectedResponseData = getRandomStreamData();
		String expectedResponseStreamData = "   " + expectedResponseData + ">";
		when(isMock.read()).thenAnswer(new InputStreamAnswer(expectedResponseStreamData));
		sut = new ObdLink(isMock, osMock);

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