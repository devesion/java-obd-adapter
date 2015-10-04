package com.devesion.commons.obd.adapter.command;

/**
 * Skeletal implementation of {@link com.devesion.commons.obd.adapter.command.ObdCommand} interface.
 */
public abstract class AbstractCommand implements ObdCommand {

	private CommandResult result = CommandResult.empty();

	public CommandResult getResult() {
		return result;
	}

	@Override
	public void setResult(CommandResult result) {
		this.result = result;
	}

	@Override
	public boolean checkResponseEnabled() {
		return true;
	}
}
