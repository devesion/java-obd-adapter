package com.devesion.obd.shared;

/**
 * Represents invalid OBD command.
 */
public class ObdInvalidCommandResponseException extends ObdCommunicationException {

	public ObdInvalidCommandResponseException() {
	}

	public ObdInvalidCommandResponseException(String message) {
		super(message);
	}

	public ObdInvalidCommandResponseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObdInvalidCommandResponseException(Throwable cause) {
		super(cause);
	}
}
