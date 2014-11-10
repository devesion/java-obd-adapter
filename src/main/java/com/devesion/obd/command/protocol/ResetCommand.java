package com.devesion.obd.command.protocol;

/**
 * Represents AT Reset Command.
 */
public class ResetCommand extends AbstractProtocolCommand {

	@Override
	public String getOperands() {
		return "Z";
	}

	@Override
	public boolean checkResponseEnabled() {
		return false;
	}
}
