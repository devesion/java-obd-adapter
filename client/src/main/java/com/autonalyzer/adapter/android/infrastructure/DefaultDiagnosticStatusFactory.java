	package com.autonalyzer.adapter.android.infrastructure;

import com.autonalyzer.adapter.android.domain.DiagnosticStatus;
import com.autonalyzer.adapter.android.domain.DiagnosticStatusFactory;
import com.autonalyzer.adapter.android.infrastructure.gateway.DiagnosticStatusGateway;
import com.autonalyzer.adapter.android.infrastructure.gateway.ProbingDiagnosticStatusGatewayFactory;
import com.google.common.base.Optional;
import lombok.extern.slf4j.Slf4j;

	@Slf4j
	public class DefaultDiagnosticStatusFactory implements DiagnosticStatusFactory {

		private ProbingDiagnosticStatusGatewayFactory diagnosticStatusGatewayFactory;

		private static Optional<? extends DiagnosticStatusGateway> diagnosticStatusGatewayOptional = Optional.absent();

		public DefaultDiagnosticStatusFactory() {
			this.diagnosticStatusGatewayFactory = new ProbingDiagnosticStatusGatewayFactory();
		}

		@Override
		public Optional<DiagnosticStatus> getCurrentStatus() {
			try {
				openVehicleStatusGateway();
				return readCurrentStatus();
			} catch (DiagnosticStatusReadException e) {
				log.error("cannot read vehicle status - {}", e.getMessage());
				closeVehicleStatusGateway();
				return Optional.absent();
			}
		}

		private void openVehicleStatusGateway() {
			if (!diagnosticStatusGatewayOptional.isPresent()) {
				diagnosticStatusGatewayOptional = diagnosticStatusGatewayFactory.createDiagnosticStatusGateway();
			}
		}

		private Optional<DiagnosticStatus> readCurrentStatus() {
			DiagnosticStatus vehicleStatus = null;
			if (diagnosticStatusGatewayOptional.isPresent()) {
				DiagnosticStatusGateway diagnosticStatusGateway = diagnosticStatusGatewayOptional.get();
				vehicleStatus = diagnosticStatusGateway.readCurrentStatus();
			}

			return Optional.fromNullable(vehicleStatus);
		}

		private void closeVehicleStatusGateway() {
			if (diagnosticStatusGatewayOptional.isPresent()) {
				DiagnosticStatusGateway diagnosticStatusGateway = diagnosticStatusGatewayOptional.get();
				diagnosticStatusGateway.close();
				diagnosticStatusGatewayOptional = Optional.absent();
			}
		}
	}
