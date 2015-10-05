package com.autonalyzer.adapter.android.infrastructure.gateway.elm;

import com.autonalyzer.adapter.android.domain.DiagnosticStatus;
import com.autonalyzer.adapter.android.infrastructure.gateway.DiagnosticStatusGateway;
import com.autonalyzer.adapter.android.infrastructure.transport.DiagnosticTransport;
import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.command.at.AdaptiveTimeoutProtocolCommand;
import com.devesion.commons.obd.adapter.command.at.ResetCommand;
import com.devesion.commons.obd.adapter.command.at.SelectProtocolCommand;
import com.devesion.commons.obd.adapter.command.at.SetEchoCommand;
import com.devesion.commons.obd.adapter.command.at.SetHeadersCommand;
import com.devesion.commons.obd.adapter.command.at.SetLineFeedCommand;
import com.devesion.commons.obd.adapter.command.at.SetSpacesCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.AmbientAirTemperatureCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.EngineCoolantTemperatureCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.EngineLoadCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.EngineRpmCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.EngineRuntimeCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.FuelLevelCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.FuelPressureCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.FuelTypeCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.IntakeAirTemperatureCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.MassAirFlowCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.SensorCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.SpeedCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.sensors.ThrottlePositionCommand;
import com.devesion.commons.obd.adapter.command.invoker.CommandInvoker;
import com.devesion.commons.obd.adapter.link.ObdLink;
import com.devesion.commons.obd.adapter.link.elm.ElmLink;
import com.devesion.commons.obd.adapter.shared.ObdNoDataForCommandResponseException;
import com.devesion.commons.obd.adapter.shared.ObdNotProperlyInitializedException;
import com.google.common.util.concurrent.Uninterruptibles;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * Echo disabled
 * Linefeed disabled
 * Spaces disabled
 * Headers disabled
 * Adaptive Timing: 2
 * New Protocol: Automatic
 * Headers enabled
 * Headers disabled
 */
@Slf4j
public class ElmDiagnosticStatusGateway implements DiagnosticStatusGateway {

	private static final int SLOW_STATUS_DURATION = 10;
	private static final int VERY_SLOW_STATUS_DURATION = 60;

	private boolean opened = false;
	private boolean initialized = false;

	private Instant lastSlowStatusTime = Instant.now();
	private Instant lastVerySlowStatusTime = Instant.now();

	private final DiagnosticStatus diagnosticStatus = new DiagnosticStatus();
	private final DiagnosticTransport diagnosticTransport;

	public ElmDiagnosticStatusGateway(DiagnosticTransport diagnosticTransport) {
		this.diagnosticTransport = diagnosticTransport;
	}

	@Override
	public void open() {
		if (!opened) {
			openTransport();
			opened = true;
		}
	}

	private void initialize() {
		if (!initialized) {
			initializeCommands();
			initialized = true;
		}
	}

	private void initializeCommands() {
		log.info("Initializing ELM protocol");
		invokeCommandQuietly(new ResetCommand());
//		invokeCommandQuietly(new SetBaudRateCommand());
//		invokeCommandQuietly(new EnableBaudRateCommand());
		invokeCommandQuietly(new ResetCommand());
		invokeCommand(new SetEchoCommand(false));
		invokeCommand(new SetLineFeedCommand(false));
		invokeCommand(new SetHeadersCommand(false));
		invokeCommand(new SetSpacesCommand(false));
		invokeCommand(new AdaptiveTimeoutProtocolCommand());
		invokeCommand(new SelectProtocolCommand());
	}

	@Override
	public DiagnosticStatus readCurrentStatus() {
		try {
			open();
			initialize();
			readFastStatus(diagnosticStatus);
			readSlowStatus(diagnosticStatus);
			readVerySlowStatus(diagnosticStatus);
		} catch (ObdNotProperlyInitializedException e) {
			log.error("Reinitializing ELM due to {}", e.getMessage());
			deinitialize();
			close();
			sleepGap();
		} catch (Exception e) {
			log.error("Invoking fail - {}", e);
		}

		return diagnosticStatus;
	}

	private void readFastStatus(DiagnosticStatus diagnosticStatus) {
		diagnosticStatus.setRpm(readEngineRpm());
		diagnosticStatus.setSpeed(readVehicleSpeed());
		diagnosticStatus.setThrottlePosition(readThrottlePositionPercentage());
		diagnosticStatus.setMassAirFlow(readMassAirFlow());
		diagnosticStatus.setLoad(readEngineLoad());
	}

	private void readSlowStatus(DiagnosticStatus diagnosticStatus) {
		Instant now = Instant.now();
		Duration duration = Duration.between(lastSlowStatusTime, now);
		if (duration.getSeconds() > SLOW_STATUS_DURATION) {
			diagnosticStatus.setFuelPressure(readFuelPressure());
			diagnosticStatus.setCoolantTemperature(readCoolantTemperature());
			diagnosticStatus.setIntakeAirTemperature(readIntakeAirTemperature());
			lastSlowStatusTime = Instant.now();
		}
	}

	private void readVerySlowStatus(DiagnosticStatus diagnosticStatus) {
		Instant now = Instant.now();
		Duration duration = Duration.between(lastVerySlowStatusTime, now);
		if (duration.getSeconds() > VERY_SLOW_STATUS_DURATION) {
			diagnosticStatus.setFuelLevel(readFuelLevel());
			diagnosticStatus.setFuelType(readFuelType());
			diagnosticStatus.setRuntime(readEngineRuntime());
			diagnosticStatus.setAmbientTemperature(readAmbientAirTemperature());
			lastVerySlowStatusTime = Instant.now();
		}
	}
	private int readEngineRpm() {
		SensorCommand command = new EngineRpmCommand();
		invokeCommand(command);
		return command.getValue().getIntValue();
	}

	private int readVehicleSpeed() {
		SensorCommand command = new SpeedCommand();
		invokeCommand(command);
		return command.getValue().getIntValue();
	}

	private float readThrottlePositionPercentage() {
		SensorCommand command = new ThrottlePositionCommand();
		invokeCommand(command);
		return command.getValue().getIntValue();
	}

	private double readMassAirFlow() {
		SensorCommand command = new MassAirFlowCommand();
		invokeCommand(command);
		return command.getValue().getFloatValue();
	}

	private int readEngineLoad() {
		SensorCommand command = new EngineLoadCommand();
		invokeCommand(command);
		return command.getValue().getIntValue();
	}

	private int readFuelLevel() {
		SensorCommand command = new FuelLevelCommand();
		invokeCommand(command);
		return command.getValue().getIntValue();
	}

	private int readFuelType() {
		SensorCommand command = new FuelTypeCommand();
		invokeCommand(command);
		return command.getValue().getIntValue();
	}

	private int readFuelPressure() {
		SensorCommand command = new FuelPressureCommand();
		invokeCommand(command);
		return command.getValue().getIntValue();
	}

	private int readEngineRuntime() {
		SensorCommand command = new EngineRuntimeCommand();
		invokeCommand(command);
		return command.getValue().getIntValue();
	}

	private int readAmbientAirTemperature() {
		SensorCommand command = new AmbientAirTemperatureCommand();
		invokeCommand(command);
		return command.getValue().getIntValue();
	}

	private int readCoolantTemperature() {
		SensorCommand command = new EngineCoolantTemperatureCommand();
		invokeCommand(command);
		return command.getValue().getIntValue();
	}

	private int readIntakeAirTemperature() {
		SensorCommand command = new IntakeAirTemperatureCommand();
		invokeCommand(command);
		return command.getValue().getIntValue();
	}

	private void invokeCommand(ObdCommand command) {
		try {
			CommandInvoker commandInvoker = createCommandInvoker();
			log.debug("Invoking command {}", command);
			commandInvoker.invoke(command);
		} catch (ObdNoDataForCommandResponseException e) {
			log.debug("Invoking fail - {}", e.getMessage());
		}
	}

	private void invokeCommandQuietly(ObdCommand command) {
		CommandInvoker commandInvoker = createCommandInvoker();
		log.debug("Invoking command {}", command);
		commandInvoker.invokeQuietly(command);
	}

	private CommandInvoker createCommandInvoker() {
		InputStream inputStream = diagnosticTransport.getInputStream();
		OutputStream outputStream = diagnosticTransport.getOutputStream();
		ObdLink obdLink = new ElmLink(inputStream, outputStream);
		return new CommandInvoker(obdLink);
	}

	private void sleepGap() {
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
	}

	@Override
	public void close() {
		closeTransport();
		opened = false;
	}

	private void deinitialize() {
		initialized = false;
	}

	private void openTransport() {
		diagnosticTransport.open();
	}

	private void closeTransport() {
		diagnosticTransport.close();
	}
}
