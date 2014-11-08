package com.devesion.obd;

import com.devesion.obd.command.diagnostic.sensors.EngineCoolantTemperatureCommand;
import com.devesion.obd.command.diagnostic.sensors.EngineRpmCommand;
import com.devesion.obd.command.diagnostic.sensors.MassAirFlowCommand;
import com.devesion.obd.command.diagnostic.sensors.ThrottlePositionCommand;
import com.devesion.obd.command.invoker.CommandInvoker;
import com.devesion.obd.command.protocol.SelectProtocolCommand;
import com.devesion.obd.command.protocol.SetEchoCommand;
import com.devesion.obd.link.ObdLink;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 *
 */
public class ObdAdapterClient implements SerialPortEventListener {
	private static final int TIME_OUT = 2000;
	private static final int DATA_RATE = 9600;
	private InputStream is;
	private OutputStream os;

	public static void main(String[] args) {
		ObdAdapterClient client = new ObdAdapterClient();
		client.run();
	}

	private void run() {
		String wantedPortName = "/dev/pts/34";
		System.setProperty("gnu.io.rxtx.SerialPorts", wantedPortName);
		Enumeration portIdentifiers = CommPortIdentifier.getPortIdentifiers();
		CommPortIdentifier portId = null;

		while (portIdentifiers.hasMoreElements()) {
			CommPortIdentifier pid = (CommPortIdentifier) portIdentifiers.nextElement();
			System.out.println("PORT " + pid.getName());
			if (pid.getPortType() == CommPortIdentifier.PORT_SERIAL &&
					pid.getName().equals(wantedPortName)) {
				portId = pid;
				break;
			}
		}

		try {
			// open serial port, and use class name for the appName.
			SerialPort serialPort = (SerialPort) portId.open(ObdAdapterClient.class.getName(), TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			is = serialPort.getInputStream();
			os = serialPort.getOutputStream();

			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(false);
		} catch (Exception e) {
			System.err.println(e.toString());
		}

		ObdLink obdLink = new ObdLink(is, os);
		CommandInvoker commandInvoker = new CommandInvoker(obdLink);

		SetEchoCommand setEchoCommand = SetEchoCommand.on();
		commandInvoker.invoke(setEchoCommand);

		SelectProtocolCommand selectProtocolCommand = new SelectProtocolCommand();
		commandInvoker.invoke(selectProtocolCommand);

		EngineRpmCommand engineRpmCommand = new EngineRpmCommand();
		commandInvoker.invoke(engineRpmCommand);
		System.out.println(engineRpmCommand.getValue());

//		EngineLoadCommand engineLoadCommand = new EngineLoadCommand();
//		commandInvoker.invoke(engineLoadCommand);
//		System.out.println(engineLoadCommand.getValue());

		EngineCoolantTemperatureCommand engineCoolantTemperatureCommand = new EngineCoolantTemperatureCommand();
		commandInvoker.invoke(engineCoolantTemperatureCommand);
		System.out.println(engineCoolantTemperatureCommand.getValue());

//		IntakeAirTemperatureCommand intakeAirTemperatureCommand = new IntakeAirTemperatureCommand();
//		commandInvoker.invoke(intakeAirTemperatureCommand);
//		System.out.println(intakeAirTemperatureCommand.getValue());

		MassAirFlowCommand massAirFlowCOmmand = new MassAirFlowCommand();
		commandInvoker.invoke(massAirFlowCOmmand);
		System.out.println(massAirFlowCOmmand.getValue());

		ThrottlePositionCommand throttlePositionCommand = new ThrottlePositionCommand();
		commandInvoker.invoke(throttlePositionCommand);
		System.out.println(throttlePositionCommand.getValue());

//		EngineRuntimeCommand engineRuntimeCommand = new EngineRuntimeCommand();
//		commandInvoker.invoke(engineRuntimeCommand);
//		System.out.println(engineRuntimeCommand.getValue());



	}

	@Override
	public void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				//String inputLine = is.readLine();
				//System.out.println(inputLine);
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
		// Ignore all the other eventTypes, but you should consider the other
	}
}
