package com.devesion.obd.shared;

import com.devesion.obd.command.ObdCommand;

/**
 * Represents OBD "NO DATA" response.
 */
public class ObdNoDataForCommandResponseException extends ObdCommandResponseException {

	public ObdNoDataForCommandResponseException(ObdCommand command) {
		super(command);
	}
}
