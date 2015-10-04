package com.autonalyzer.adapter.android.infrastructure.transport.serial;

import com.autonalyzer.adapter.android.infrastructure.transport.DiagnosticTransport;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

@Slf4j
public class SerialDiagnosticTransport implements DiagnosticTransport, SerialPortEventListener {

	private static final int TIME_OUT = 2000;
//	private static final int DATA_RATE = 38400;

//	private static final int DATA_RATE = 57600;
	private static final int DATA_RATE = 115200;
//	private static final int DATA_RATE = 38400;
//	private static final int DATA_RATE = 14400;
	private InputStream is;
	private OutputStream os;

	@Override
	public void close() {
		try {
			if (is != null) {
				is.close();
			}

			if (os != null) {
				os.close();
			}
		} catch (IOException e) {
			log.error("cannot close streams");
		}
	}

	@Override
	public void open() {
		log.info("opening serial transport");
		String wantedPortName = "/dev/ttyUSB0";
//		String wantedPortName = "/dev/rfcomm1";
		System.setProperty("gnu.io.rxtx.SerialPorts", wantedPortName);
		Enumeration portIdentifiers = CommPortIdentifier.getPortIdentifiers();

		CommPortIdentifier portId = null;

		while (portIdentifiers.hasMoreElements()) {
			CommPortIdentifier pid = (CommPortIdentifier) portIdentifiers.nextElement();
			log.info("pid {}", pid);
			if (pid.getPortType() == CommPortIdentifier.PORT_SERIAL &&
					pid.getName().equals(wantedPortName)) {
				portId = pid;
				break;
			}
		}

		if (portId == null) {
			return;
		}

		try {
			// open serial port, and use class name for the appName.
			SerialPort serialPort = (SerialPort) portId.open(SerialDiagnosticTransport.class.getName(), TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_XONXOFF_IN);
			serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_XONXOFF_OUT);

			// open the streams
			is = serialPort.getInputStream();
			os = serialPort.getOutputStream();

			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(false);
			log.info("serial transport opened");
		} catch (Exception e) {
			log.error("cannot connect to serial port", e);
		}
	}

	@Override
	public InputStream getInputStream() {
		return is;
	}

	@Override
	public OutputStream getOutputStream() {
		return os;
	}

	@Override
	public void serialEvent(SerialPortEvent oEvent) {
		// Ignore all the other eventTypes, but you should consider the other
	}
}
