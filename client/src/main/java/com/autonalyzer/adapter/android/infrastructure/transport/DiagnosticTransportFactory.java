package com.autonalyzer.adapter.android.infrastructure.transport;

import java.util.List;

public interface DiagnosticTransportFactory {

	List<DiagnosticTransport> createAvailableTransports();
}
