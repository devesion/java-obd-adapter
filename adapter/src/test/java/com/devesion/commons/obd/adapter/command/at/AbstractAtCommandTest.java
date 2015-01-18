package com.devesion.commons.obd.adapter.command.at;

import com.devesion.commons.obd.adapter.command.ObdCommandVisitor;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AbstractAtCommandTest {

	@Mock
	private ObdCommandVisitor protocolCommandVisitorMock;

	private AbstractAtCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		sut = new FakeAbstractProtocolCommand();
	}

	@Test
	public void testAccept() throws Exception {
		// given

		// when
		sut.accept(protocolCommandVisitorMock);

		// then
		verify(protocolCommandVisitorMock).visit(sut);
	}

	private static class FakeAbstractProtocolCommand extends AbstractAtCommand {
		@Override
		public String getOperands() {
			return null;
		}
	}
}