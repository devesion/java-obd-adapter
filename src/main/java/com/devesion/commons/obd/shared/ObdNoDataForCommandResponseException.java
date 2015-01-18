package com.devesion.commons.obd.shared;

import com.devesion.commons.obd.command.ObdCommand;

/**
 * Represents OBD "NO DATA" response.
 */
public class ObdNoDataForCommandResponseException extends ObdCommandResponseException {

	public ObdNoDataForCommandResponseException(ObdCommand command) {
		super(command);
	}
}
