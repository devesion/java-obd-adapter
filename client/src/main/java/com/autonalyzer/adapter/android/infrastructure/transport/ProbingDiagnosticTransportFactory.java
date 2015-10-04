package com.autonalyzer.adapter.android.infrastructure.transport;

import com.autonalyzer.adapter.android.infrastructure.transport.serial.SerialDiagnosticTransportFactory;
import com.google.common.collect.Lists;

import java.util.List;

public class ProbingDiagnosticTransportFactory implements DiagnosticTransportFactory {

	private List<DiagnosticTransportProbe> probes = Lists.newArrayList();

	public ProbingDiagnosticTransportFactory() {
		DiagnosticTransportProbe bluetoothTransportProbe = new SerialDiagnosticTransportFactory();
		registerDiagnosticTransportFactory(bluetoothTransportProbe);
	}

	private void registerDiagnosticTransportFactory(DiagnosticTransportProbe diagnosticTransportProbe) {
		probes.add(diagnosticTransportProbe);
	}

	@Override
	public List<DiagnosticTransport> createAvailableTransports() {
		List<DiagnosticTransport> allAvailableTransports = Lists.newArrayList();
		for (DiagnosticTransportProbe probe : probes) {
			List<DiagnosticTransport> probedTransports = probe.createAvailableTransports();
			allAvailableTransports.addAll(probedTransports);
		}

		return allAvailableTransports;
	}
}
