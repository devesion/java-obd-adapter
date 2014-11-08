package com.devesion.obd.command;

import com.devesion.obd.command.invoker.CommandResult;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class AbstractCommandTest {

	@Mock
	private CommandResult commandResultMock;

	private AbstractCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		sut = new FakeAbstractCommand();
	}

	@Test
	public void testGetResult() throws Exception {
		// given

		// when
		sut.setResult(commandResultMock);
		CommandResult commandResult = sut.getResult();

		// then
		assertThat(commandResult).isEqualTo(commandResultMock);
	}

	private static class FakeAbstractCommand extends AbstractCommand {
	}
}