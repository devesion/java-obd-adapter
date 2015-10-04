package com.autonalyzer.adapter.android.infrastructure.gateway;

public interface ProbingDiagnosticStatusGateway extends DiagnosticStatusGateway {

	boolean probe();
}
