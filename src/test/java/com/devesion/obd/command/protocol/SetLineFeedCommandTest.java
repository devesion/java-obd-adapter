package com.devesion.obd.command.protocol;

public class SetLineFeedCommandTest extends AbstractSetStateCommandTest {

	@Override
	protected String getOperandPrefix() {
		return "L";
	}

	@Override
	protected ProtocolCommand createCommand(boolean state) {
		return new SetLineFeedCommand(state);
	}
}