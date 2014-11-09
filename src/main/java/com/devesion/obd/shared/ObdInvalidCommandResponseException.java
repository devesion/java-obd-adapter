package com.devesion.obd.shared;

import com.devesion.obd.command.ObdCommand;

/**
 * Represents invalid OBD command.
 */
public class ObdInvalidCommandResponseException extends ObdCommandResponseException {

	public ObdInvalidCommandResponseException(ObdCommand command) {
		super(command);
	}
}
