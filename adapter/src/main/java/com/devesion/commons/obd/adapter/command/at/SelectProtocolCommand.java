package com.devesion.commons.obd.adapter.command.at;

/**
 * Represents AT Select Protocol Command.
 */
public class SelectProtocolCommand extends AbstractAtCommand {

	@Override
	public String getOperands() {
		return "SP 0";
	}
}
