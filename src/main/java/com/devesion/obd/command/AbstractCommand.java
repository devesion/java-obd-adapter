package com.devesion.obd.command;

import com.devesion.obd.command.invoker.CommandResult;
import lombok.ToString;

/**
 * Skeletal implementation of {@link com.devesion.obd.command.ObdCommand} interface.
 */
@ToString
public abstract class AbstractCommand implements ObdCommand {

	private CommandResult result;

	public CommandResult getResult() {
		return result;
	}

	@Override
	public void setResult(CommandResult result) {
		this.result = result;
	}
}
