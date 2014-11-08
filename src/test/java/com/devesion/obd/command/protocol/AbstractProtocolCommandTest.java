package com.devesion.obd.command.protocol;

import com.devesion.obd.command.ObdCommandVisitor;
import junit.framework.TestCase;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AbstractProtocolCommandTest extends TestCase {

	@Mock
	private ObdCommandVisitor protocolCommandVisitorMock;

	private AbstractProtocolCommand sut;

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

	private static class FakeAbstractProtocolCommand extends AbstractProtocolCommand {
		@Override
		public String getOperands() {
			return null;
		}
	}
}