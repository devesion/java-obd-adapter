package com.devesion.commons.obd.adapter.command.invoker;

import com.devesion.commons.obd.adapter.command.CommandResult;
import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.link.ObdLink;
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

	public void invokeQuietly(ObdCommand command) {
		try {
			invoke(command);
		} catch (Exception e) {
			log.error("cannot invoke command {} - {}", command, e.getMessage());
		}
	}

	public void invoke(ObdCommand command) {
		log.debug("invoking OBD Command '{}'", command);
		CommandResult result = obdLink.sendCommand(command);
		log.debug("OBD Command result '{}'", result);
		command.setResult(result);
	}
}
