package com.autonalyzer.adapter.android.infrastructure.gateway;

import com.autonalyzer.adapter.android.infrastructure.gateway.elm.ProbingElmDiagnosticStatusGateway;
import com.autonalyzer.adapter.android.infrastructure.transport.DiagnosticTransport;
import com.autonalyzer.adapter.android.infrastructure.transport.DiagnosticTransportFactory;
import com.autonalyzer.adapter.android.infrastructure.transport.ProbingDiagnosticTransportFactory;
import com.google.common.base.Optional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ProbingDiagnosticStatusGatewayFactory {

	private DiagnosticTransportFactory vehicleDiagnosticTransportFactory = new ProbingDiagnosticTransportFactory();

	public Optional<? extends DiagnosticStatusGateway> createDiagnosticStatusGateway() {
		log.info("creating new diagnosticStatusGateway");

		List<DiagnosticTransport> transports = vehicleDiagnosticTransportFactory.createAvailableTransports();
		for (DiagnosticTransport transport : transports) {
			Optional<? extends DiagnosticStatusGateway> diagnosticStatusGatewayOptional = probeSingleTransport(transport);
			if (diagnosticStatusGatewayOptional.isPresent()) {
				return diagnosticStatusGatewayOptional;
			}
		}

		return Optional.absent();
	}

	private Optional<? extends DiagnosticStatusGateway> probeSingleTransport(DiagnosticTransport transport) {
		log.info("probing transport {}", transport);

		ProbingDiagnosticStatusGateway diagnosticStatusGateway = new ProbingElmDiagnosticStatusGateway(transport);
		if (diagnosticStatusGateway.probe()) {
			log.info("probe OK");
			return Optional.of(diagnosticStatusGateway);
		} else {
			log.info("probe FAIL");
			diagnosticStatusGateway.close();
			return Optional.absent();
		}
	}
}
