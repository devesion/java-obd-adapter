package com.devesion.obd.command.protocol;

/**
 * Represents AT Set Echo Command.
 */
public class SetEchoCommand extends AbstractProtocolCommand {

	private boolean enabled;

	private SetEchoCommand(boolean enabled) {
		this.enabled = enabled;
	}

	public static SetEchoCommand on() {
		return new SetEchoCommand(true);
	}

	public static SetEchoCommand off() {
		return new SetEchoCommand(false);
	}

	@Override
	public String getOperands() {
		int enabledInt = enabled ? 1 : 0;
		return "E" + enabledInt;
	}
}
