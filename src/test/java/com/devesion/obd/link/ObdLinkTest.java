package com.devesion.obd.link;

import com.devesion.obd.TestSupport;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.fest.assertions.api.Assertions.assertThat;
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
		InputStream is = new ByteArrayInputStream(streamData.getBytes());
		sut = new ObdLink(is, osMock);

		// when
		String readData = sut.readData();

		// then
		assertThat(readData).isEqualTo(expectedData);
	}

	@Test
	public void sendDataShouldWriteDataToTheOutputStream() throws Exception {
		// given
		String expectedData = getRandomStreamData();
		ByteArrayOutputStream os = new ByteArrayOutputStream(0);
		sut = new ObdLink(isMock, os);

		// when
		sut.sendData(expectedData);

		// then
		assertThat(os.toByteArray()).isEqualTo(expectedData.getBytes());
	}

	private String getRandomStreamData() {
		return TestSupport.getRandomString() + " " + TestSupport.getRandomString() + " " + TestSupport.getRandomString();
	}
}