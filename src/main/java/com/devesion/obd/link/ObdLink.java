package com.devesion.obd.link;

import com.devesion.obd.shared.ObdCommunicationException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Represents IO link between two nodes (ie. bluetooth device and PC).
 */
@Slf4j
public class ObdLink {
	private static final char ELM_PROMPT = '>';
	private static final char ELM_SPACE = ' ';

	private InputStream inputStream;
	private OutputStream outputStream;

	public ObdLink(InputStream inputStream, OutputStream outputStream) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
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
		StringBuilder res = new StringBuilder();
		char c;
		while ((c = readChar()) != ELM_PROMPT) {
			log.debug("read char '{}'", c);
			if (c != ELM_SPACE) {
				res.append(c);
			}
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
