package com.devesion.obd.shared;

/**
 * Represents OBD "NO DATA" response.
 */
public class ObdNoDataForCommandResponseException extends ObdCommunicationException {

	public ObdNoDataForCommandResponseException() {
	}

	public ObdNoDataForCommandResponseException(String message) {
		super(message);
	}

	public ObdNoDataForCommandResponseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObdNoDataForCommandResponseException(Throwable cause) {
		super(cause);
	}
}
