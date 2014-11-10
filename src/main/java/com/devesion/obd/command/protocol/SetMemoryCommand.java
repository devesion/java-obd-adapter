package com.devesion.obd.command.protocol;

/**
 * Represents AT Set Memory On/Off Command.
 */
public class SetMemoryCommand extends AbstractProtocolCommand {

	private boolean enabled;

	private SetMemoryCommand(boolean enabled) {
		this.enabled = enabled;
	}

	public static SetMemoryCommand on() {
		return new SetMemoryCommand(true);
	}

	public static SetMemoryCommand off() {
		return new SetMemoryCommand(false);
	}

	@Override
	public String getOperands() {
		int enabledInt = enabled ? 1 : 0;
		return "M" + enabledInt;
	}
}
