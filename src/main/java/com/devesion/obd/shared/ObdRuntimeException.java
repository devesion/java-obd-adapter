package com.devesion.obd.shared;

/**
 * Runtime exception superclass for OBD Adapter.
 */
public abstract class ObdRuntimeException extends RuntimeException {

	public ObdRuntimeException() {
	}

	public ObdRuntimeException(String message) {
		super(message);
	}

	public ObdRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObdRuntimeException(Throwable cause) {
		super(cause);
	}
}
