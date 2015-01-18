package com.devesion.commons.obd.adapter.command.at;

/**
 * Represents AT Set Memory On/Off Command.
 */
public class SetMemoryCommand extends AbstractSetStateCommand {

	private static final String SET_MEMORY_PREFIX = "M";

	public SetMemoryCommand(boolean enabled) {
		super(SET_MEMORY_PREFIX, enabled);
	}
}
