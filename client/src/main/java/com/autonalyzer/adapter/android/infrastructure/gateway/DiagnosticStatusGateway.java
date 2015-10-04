package com.autonalyzer.adapter.android.infrastructure.gateway;

import com.autonalyzer.adapter.android.domain.DiagnosticStatus;

import java.io.Closeable;

public interface DiagnosticStatusGateway extends Closeable {

	void open();

	DiagnosticStatus readCurrentStatus();

	void close();
}
