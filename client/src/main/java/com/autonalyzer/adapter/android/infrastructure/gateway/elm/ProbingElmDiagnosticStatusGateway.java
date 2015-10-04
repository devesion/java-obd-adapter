package com.autonalyzer.adapter.android.infrastructure.gateway.elm;

import com.autonalyzer.adapter.android.infrastructure.gateway.ProbingDiagnosticStatusGateway;
import com.autonalyzer.adapter.android.infrastructure.transport.DiagnosticTransport;

public class ProbingElmDiagnosticStatusGateway extends ElmDiagnosticStatusGateway implements ProbingDiagnosticStatusGateway {

	public ProbingElmDiagnosticStatusGateway(DiagnosticTransport diagnosticTransport) {
		super(diagnosticTransport);
	}

	@Override
	public boolean probe() {
		try {
			open();
			return true;
		} catch (Exception e) {
			close();
			return false;
		}
	}
}
