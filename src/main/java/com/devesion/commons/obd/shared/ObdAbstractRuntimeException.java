package com.devesion.commons.obd.shared;

/**
 * Runtime exception superclass for OBD Adapter.
 */
public abstract class ObdAbstractRuntimeException extends RuntimeException {

	public ObdAbstractRuntimeException() {
	}

	public ObdAbstractRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
}
