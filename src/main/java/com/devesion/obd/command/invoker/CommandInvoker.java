package com.devesion.obd.command.invoker;

import com.devesion.obd.command.CommandResult;
import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.link.ObdLink;
import lombok.extern.slf4j.Slf4j;

/**
 * Responsible for invoking OBD Commands.
 */
@Slf4j
public class CommandInvoker {

	private final ObdLink obdLink;

	public CommandInvoker(ObdLink obdLink) {
		this.obdLink = obdLink;
	}

	public void invoke(ObdCommand command) {
		log.debug("invoking OBD Command '{}'", command);
		CommandResult result = obdLink.sendCommand(command);
		log.debug("OBD Command result '{}'", result);

		command.setResult(result);
	}
}
