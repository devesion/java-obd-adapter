package com.devesion.obd.command.protocol;

/**
 * Represents AT Defaults Command.
 */
public class SetDefaultsCommand extends AbstractProtocolCommand {

	@Override
	public String getOperands() {
		return "D";
	}
}
