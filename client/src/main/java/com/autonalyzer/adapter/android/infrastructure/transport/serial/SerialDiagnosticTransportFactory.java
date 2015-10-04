package com.autonalyzer.adapter.android.infrastructure.transport.serial;

import com.autonalyzer.adapter.android.infrastructure.transport.DiagnosticTransport;
import com.autonalyzer.adapter.android.infrastructure.transport.DiagnosticTransportProbe;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class SerialDiagnosticTransportFactory implements DiagnosticTransportProbe {

	@Override
	public List<DiagnosticTransport> createAvailableTransports() {
		DiagnosticTransport diagnosticTransport = new SerialDiagnosticTransport();
		return Lists.newArrayList(diagnosticTransport);
	}
}
