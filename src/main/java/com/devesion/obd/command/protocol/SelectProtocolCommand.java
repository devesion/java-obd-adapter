package com.devesion.obd.command.protocol;

/**
 * Represents AT Select Protocol Command.
 */
public class SelectProtocolCommand extends AbstractProtocolCommand {

	@Override
	public String getOperands() {
		return "SP 0";
	}
}
