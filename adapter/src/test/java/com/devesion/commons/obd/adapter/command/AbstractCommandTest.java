package com.devesion.commons.obd.adapter.command;

import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.verifyZeroInteractions;

public class AbstractCommandTest {

	@Mock
	private CommandResult commandResultMock;

	@Mock
	private ObdCommandVisitor obdCommandVisitorMock;

	private AbstractCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		sut = new FakeAbstractCommand();
	}

	@Test
	public void getResultShouldReturnSetValue() throws Exception {
		// given

		// when
		sut.setResult(commandResultMock);
		CommandResult commandResult = sut.getResult();

		// then
		assertThat(commandResult).isEqualTo(commandResultMock);
	}

	@Test
	public void acceptShouldDoNothing() throws Exception {
		// given

		// when
		sut.accept(obdCommandVisitorMock);

		// then
		verifyZeroInteractions(obdCommandVisitorMock);
	}

	private static class FakeAbstractCommand extends AbstractCommand {
		@Override
		public void accept(ObdCommandVisitor visitor) {
		}
	}
}