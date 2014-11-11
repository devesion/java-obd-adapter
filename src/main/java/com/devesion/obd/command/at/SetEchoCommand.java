package com.devesion.obd.command.at;

/**
 * Represents AT Set Echo On/Off Command.
 */
public class SetEchoCommand extends AbstractSetStateCommand {

	private static final String SET_ECHO_PREFIX = "E";

	public SetEchoCommand(boolean enabled) {
		super(SET_ECHO_PREFIX, enabled);
	}
}
