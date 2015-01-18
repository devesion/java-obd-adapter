package com.devesion.commons.obd.command.at;

/**
 * Represents AT Select Protocol Command.
 */
public class SelectProtocolCommand extends AbstractAtCommand {

	@Override
	public String getOperands() {
		return "SP 0";
	}
}
