package com.devesion.obd.command;

import lombok.ToString;

/**
 * Skeletal implementation of {@link com.devesion.obd.command.ObdCommand} interface.
 */
@ToString
abstract class AbstractCommand implements ObdCommand {

	private CommandResult result;

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
