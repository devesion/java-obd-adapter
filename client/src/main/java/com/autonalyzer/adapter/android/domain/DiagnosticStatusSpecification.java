package com.autonalyzer.adapter.android.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class DiagnosticStatusSpecification {

	private String trackId;

	private DiagnosticTransportSpecification diagnosticTransportSpecification;

	public DiagnosticStatusSpecification(DiagnosticTransportSpecification diagnosticTransportSpecification) {
		this.diagnosticTransportSpecification = diagnosticTransportSpecification;
	}
}
