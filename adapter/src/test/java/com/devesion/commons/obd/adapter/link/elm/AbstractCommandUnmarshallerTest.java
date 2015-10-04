package com.devesion.commons.obd.adapter.link.elm;

import com.devesion.commons.obd.adapter.command.CommandResult;
import com.devesion.commons.obd.adapter.command.ObdCommand;
import junit.framework.TestCase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class AbstractCommandUnmarshallerTest extends TestCase {

	private AbstractCommandUnmarshaller sut;

	@BeforeMethod
	public void beforeMethod() {
		sut = new FakeAbstractCommandUnmarshaller();
	}

	@DataProvider(name = "responselues")
	public Object[][] createData1() {
		return new Object[][] {
				{ "1234 1234", "12341234"},
				{ "123\n41\n2	3\n41 2", "1234123412"},
				{ "0:410C0A820100\n" + "1:076D0000000000", "410C0A820100076D0000000000"}
		};
	}

	@Test(dataProvider = "responselues")
	public void normalizeResponseShouldNormalizeResponse(String responseToNormalize, String expectedResponse) {
		// given

		// when
		String normalizedResponse = sut.normalizeResponse(responseToNormalize);

		// then
		assertThat(normalizedResponse).isEqualTo(expectedResponse);
	}

	private class FakeAbstractCommandUnmarshaller extends AbstractCommandUnmarshaller {

		@Override
		public CommandResult unmarshal(ObdCommand command, String data) {
			return null;
		}
	}
}