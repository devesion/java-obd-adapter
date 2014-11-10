package com.devesion.obd.command.protocol;

public class SetSpacesCommandTest extends AbstractSetStateCommandTest {

	@Override
	protected String getOperandPrefix() {
		return "S";
	}

	@Override
	protected ProtocolCommand createCommand(boolean state) {
		return new SetSpacesCommand(state);
	}
}