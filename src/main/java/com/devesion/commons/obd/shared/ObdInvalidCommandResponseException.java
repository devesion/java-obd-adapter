package com.devesion.commons.obd.shared;

import com.devesion.commons.obd.command.ObdCommand;

/**
 * Represents invalid OBD command.
 */
public class ObdInvalidCommandResponseException extends ObdCommandResponseException {

	private String responseData;

	public ObdInvalidCommandResponseException(ObdCommand command, String responseData) {
		super(command);
		this.responseData = responseData;
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		String superMessage = super.getMessage();
		sb.append(superMessage).append(", responseData - '").append(responseData).append("'");
		return sb.toString();
	}
}
