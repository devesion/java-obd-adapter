package com.devesion.commons.obd.adapter.shared;

import com.devesion.commons.obd.adapter.command.ObdCommand;

/**
 * Represents OBD "SEARCHING..." or "BUS INIT" response.
 */
public class ObdNotProperlyInitializedException extends ObdCommandResponseException {

	public ObdNotProperlyInitializedException(ObdCommand command, String responseData) {
		super(command, responseData);
	}
}
