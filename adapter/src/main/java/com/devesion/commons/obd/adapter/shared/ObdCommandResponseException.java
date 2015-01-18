package com.devesion.commons.obd.adapter.shared;

import com.devesion.commons.obd.adapter.command.ObdCommand;
import lombok.Getter;

/**
 * Represents invalid OBD command.
 */
public class ObdCommandResponseException extends ObdCommunicationException {

	@Getter
	private ObdCommand command;

	public ObdCommandResponseException(ObdCommand command) {
		this.command = command;
	}

	@Override
	public String getMessage() {
		return "command '" + command + "'";
	}
}
