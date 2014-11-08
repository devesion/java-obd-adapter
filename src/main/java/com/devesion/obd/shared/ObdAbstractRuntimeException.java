package com.devesion.obd.shared;

/**
 * Runtime exception superclass for OBD Adapter.
 */
public abstract class ObdAbstractRuntimeException extends RuntimeException {

	public ObdAbstractRuntimeException() {
	}

	public ObdAbstractRuntimeException(String message) {
		super(message);
	}

	public ObdAbstractRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObdAbstractRuntimeException(Throwable cause) {
		super(cause);
	}
}
