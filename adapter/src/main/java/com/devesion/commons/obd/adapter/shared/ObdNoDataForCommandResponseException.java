package com.devesion.commons.obd.adapter.shared;

import com.devesion.commons.obd.adapter.command.ObdCommand;

/**
 * Represents OBD "NO DATA" response.
 */
public class ObdNoDataForCommandResponseException extends ObdCommandResponseException {

	public ObdNoDataForCommandResponseException(ObdCommand command) {
		super(command);
	}

	public ObdNoDataForCommandResponseException(ObdCommand command, String responseData) {
		super(command, responseData);
	}
}
