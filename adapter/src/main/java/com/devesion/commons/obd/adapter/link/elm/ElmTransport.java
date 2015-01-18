package com.devesion.commons.obd.adapter.link.elm;

import com.devesion.commons.obd.adapter.shared.ObdCommunicationException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Represents ELM IO transport between two nodes (ie. bluetooth device and PC).
 */
@Slf4j
public class ElmTransport {
	private static final char ELM_PROMPT = '>';

	private final InputStream inputStream;
	private final OutputStream outputStream;

	public ElmTransport(InputStream inputStream, OutputStream outputStream) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}

	public String sendDataAndReadResponse(String data) {
		sendData(data);
		return readData();
	}

	public void sendData(String data) {
		log.debug("Sending bytes '{}'", data);
		writeBytes(data);
	}

	private void writeBytes(String data) {
		try {
			outputStream.write(data.getBytes());
			outputStream.flush();
		} catch (IOException e) {
			throw new ObdCommunicationException("cannot send data to output stream", e);
		}
	}

	public String readData() {
		log.debug("waiting for response");
		StringBuilder res = new StringBuilder();
		char c;
		while ((c = readChar()) != ELM_PROMPT) {
			log.debug("read char '{}'", c);
			res.append(c);
		}

		log.debug("reading end");
		String data = res.toString().trim();
		log.debug("Read raw data '{}'", data);
		return data;
	}

	private char readChar() {
		try {
			return (char) inputStream.read();
		} catch (IOException e) {
			throw new ObdCommunicationException("cannot read data from input stream", e);
		}
	}
}
