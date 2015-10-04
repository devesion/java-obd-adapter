package com.devesion.commons.obd.adapter.shared;

import com.devesion.commons.obd.adapter.command.ObdCommand;
import lombok.Getter;

/**
 * Represents invalid OBD command.
 */
public class ObdCommandResponseException extends ObdCommunicationException {

	@Getter
	private ObdCommand command;

	private String responseData;

	public ObdCommandResponseException(ObdCommand command) {
		this.command = command;
	}

	public ObdCommandResponseException(ObdCommand command, String responseData) {
		this.command = command;
		this.responseData = responseData;
	}

	@Override
	public String getMessage() {
		String message = "command '" + command + "";

		if (responseData != null) {
			message += "', response '" + responseData + "'";
		}

		return message;
	}
}
