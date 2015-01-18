package com.devesion.commons.obd.adapter.command.diagnostic;

import com.devesion.commons.obd.adapter.command.ObdCommandVisitor;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AbstractDiagnosticCommandTest {

	@Mock
	private ObdCommandVisitor diagnosticCommandVisitorMock;

	private AbstractDiagnosticCommand sut;

	@BeforeMethod
	private void beforeMethod() {
		initMocks(this);
		sut = new FakeAbstractDiagnosticCommand();
	}

	@Test
	public void testAccept() throws Exception {
		// given

		// when
		sut.accept(diagnosticCommandVisitorMock);

		// then
		verify(diagnosticCommandVisitorMock).visit(sut);
	}

	private static class FakeAbstractDiagnosticCommand extends AbstractDiagnosticCommand {

		@Override
		public ObdNumberedEnum getMode() {
			return null;
		}

		@Override
		public ObdNumberedEnum getPid() {
			return null;
		}
	}
}