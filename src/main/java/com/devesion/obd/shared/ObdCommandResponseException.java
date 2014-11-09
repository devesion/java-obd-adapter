package com.devesion.obd.shared;

import com.devesion.obd.command.ObdCommand;
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
}
