package com.devesion.obd.command.protocol;

public class SetMemoryCommandTest extends AbstractSetStateCommandTest {

	@Override
	protected String getOperandPrefix() {
		return "M";
	}

	@Override
	protected ProtocolCommand createCommand(boolean state) {
		return new SetMemoryCommand(state);
	}
}