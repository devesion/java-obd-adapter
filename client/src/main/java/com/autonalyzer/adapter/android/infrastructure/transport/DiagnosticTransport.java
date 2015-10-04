package com.autonalyzer.adapter.android.infrastructure.transport;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

public interface DiagnosticTransport extends Closeable {

	void open();

	InputStream getInputStream();

	OutputStream getOutputStream();

	void close();
}
