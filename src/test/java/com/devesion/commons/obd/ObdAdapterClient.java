package com.devesion.commons.obd;

import com.devesion.commons.obd.command.at.AdaptiveTimeoutProtocolCommand;
import com.devesion.commons.obd.command.diagnostic.sensors.ThrottlePositionCommand;
import com.devesion.commons.obd.command.invoker.CommandInvoker;
import com.devesion.commons.obd.command.at.ResetCommand;
import com.devesion.commons.obd.command.at.SelectProtocolCommand;
import com.devesion.commons.obd.command.at.SetDefaultsCommand;
import com.devesion.commons.obd.command.at.SetEchoCommand;
import com.devesion.commons.obd.command.at.SetLineFeedCommand;
import com.devesion.commons.obd.command.at.SetSpacesCommand;
import com.devesion.commons.obd.link.ObdLink;
import com.devesion.commons.obd.link.elm.ElmLink;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

@Slf4j
public class ObdAdapterClient implements SerialPortEventListener {
	private static final int TIME_OUT = 2000;
	private static final int DATA_RATE = 9600;
	private static final int DATA_RATE_FAST = 57600;
	private static final int DATA_RATE_SUPER_FAST = 115200;
	private InputStream is;
	private OutputStream os;

	public static void main(String... args) {
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
			log.error("cannot connect to serial port", e);
		}

		ObdLink obdLink = new ElmLink(is, os);
		CommandInvoker commandInvoker = new CommandInvoker(obdLink);

		ResetCommand resetCommand = new ResetCommand();
		commandInvoker.invoke(resetCommand);

		SetDefaultsCommand setDefaultsCommand = new SetDefaultsCommand();
		commandInvoker.invoke(setDefaultsCommand);

		SetEchoCommand setEchoCommand = new SetEchoCommand(false);
		commandInvoker.invoke(setEchoCommand);
//
//		SetMemoryCommand setMemoryCommand = new SetMemoryCommand(false);
//		commandInvoker.invoke(setMemoryCommand);

		SetLineFeedCommand setLinefeedCommand = new SetLineFeedCommand(false);
		commandInvoker.invoke(setLinefeedCommand);

		SetSpacesCommand setSpacesCommand = new SetSpacesCommand(false);
		commandInvoker.invoke(setSpacesCommand);

		AdaptiveTimeoutProtocolCommand adaptiveTimeoutProtocol = new AdaptiveTimeoutProtocolCommand();
		commandInvoker.invoke(adaptiveTimeoutProtocol);

		SelectProtocolCommand selectProtocolCommand = new SelectProtocolCommand();
		commandInvoker.invoke(selectProtocolCommand);

//		EngineRpmCommand engineRpmCommand = new EngineRpmCommand();
//		log.info("command - '{}'", engineRpmCommand);
//		commandInvoker.invoke(engineRpmCommand);
//		log.info("command response - '{}'\n", engineRpmCommand.getValue());
//
////		EngineLoadCommand engineLoadCommand = new EngineLoadCommand();
////		commandInvoker.invoke(engineLoadCommand);
//
//		EngineCoolantTemperatureCommand engineCoolantTemperatureCommand = new EngineCoolantTemperatureCommand();
//		log.info("command - '{}'", engineCoolantTemperatureCommand);
//		commandInvoker.invoke(engineCoolantTemperatureCommand);
//		log.info("command response - '{}'\n", engineCoolantTemperatureCommand.getValue());
//
////		IntakeAirTemperatureCommand intakeAirTemperatureCommand = new IntakeAirTemperatureCommand();
////		commandInvoker.invoke(intakeAirTemperatureCommand);
//
//		MassAirFlowCommand massAirFlowCOmmand = new MassAirFlowCommand();
//		log.info("command - '{}'", massAirFlowCOmmand);
//		commandInvoker.invoke(massAirFlowCOmmand);
//		log.info("command response - '{}'\n", massAirFlowCOmmand.getValue());

		for (int i = 0; i < 1000; i++) {
			ThrottlePositionCommand throttlePositionCommand = new ThrottlePositionCommand();
			commandInvoker.invoke(throttlePositionCommand);
			log.info("throttle {}", throttlePositionCommand.getValue().getFloatValue());
		}

//		EngineRuntimeCommand engineRuntimeCommand = new EngineRuntimeCommand();
//		commandInvoker.invoke(engineRuntimeCommand);
	}

	@Override
	public void serialEvent(SerialPortEvent oEvent) {
		// Ignore all the other eventTypes, but you should consider the other
	}
}
