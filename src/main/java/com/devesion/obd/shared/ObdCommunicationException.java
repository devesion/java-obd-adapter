package com.devesion.obd.shared;

/**
 * Represents general OBD communication exception.
 */
public class ObdCommunicationException extends ObdAbstractRuntimeException {

	public ObdCommunicationException() {
	}

	public ObdCommunicationException(String message) {
		super(message);
	}

	public ObdCommunicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObdCommunicationException(Throwable cause) {
		super(cause);
	}
}
