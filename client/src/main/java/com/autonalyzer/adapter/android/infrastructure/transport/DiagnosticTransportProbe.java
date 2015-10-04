package com.autonalyzer.adapter.android.infrastructure.transport;

import java.util.List;

public interface DiagnosticTransportProbe {

	List<DiagnosticTransport> createAvailableTransports();
}
