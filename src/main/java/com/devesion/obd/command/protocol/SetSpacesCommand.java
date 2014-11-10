package com.devesion.obd.command.protocol;

/**
 * Represents AT Set Spaces On/Off Command.
 */
public class SetSpacesCommand extends AbstractSetStateCommand {

	private static final String SET_SPACES_PREFIX = "S";

	public SetSpacesCommand(boolean enabled) {
		super(SET_SPACES_PREFIX, enabled);
	}
}
