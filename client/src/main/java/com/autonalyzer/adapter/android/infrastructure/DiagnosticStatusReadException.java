package com.autonalyzer.adapter.android.infrastructure;

public class DiagnosticStatusReadException extends RuntimeException {

	public DiagnosticStatusReadException(String message) {
		super(message);
	}

	public DiagnosticStatusReadException(String message, Throwable cause) {
		super(message, cause);
	}

	public DiagnosticStatusReadException(Throwable cause) {
		super(cause);
	}
}
