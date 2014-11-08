package com.devesion.obd.command.invoker;

import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.command.invoker.marshaller.CommandMarshaller;
import com.devesion.obd.command.invoker.marshaller.CommandUnmarshaller;
import com.devesion.obd.command.invoker.marshaller.CommandUnmarshallerBridge;
import com.devesion.obd.command.invoker.marshaller.CommandMarshallerBridge;

import com.devesion.obd.link.ObdLink;
import lombok.extern.slf4j.Slf4j;

/**
 * Responsible for invoking OBD Commands.
 */
@Slf4j
public class CommandInvoker {

	private final ObdLink obdLink;
	private final CommandMarshaller commandMarshaller;
	private final CommandUnmarshaller commandUnmarshaller;

	public CommandInvoker(ObdLink obdLink) {
		this.obdLink = obdLink;
		this.commandMarshaller = new CommandMarshallerBridge();
		this.commandUnmarshaller = new CommandUnmarshallerBridge();
	}

	public CommandInvoker(ObdLink obdLink, CommandMarshaller commandMarshaller, CommandUnmarshaller commandUnmarshaller) {
		this.obdLink = obdLink;
		this.commandMarshaller = commandMarshaller;
		this.commandUnmarshaller = commandUnmarshaller;
	}

	public void invoke(ObdCommand command) {
		log.info("invoking OBD Command '{}'", command);

		String commandData = commandMarshaller.marshal(command);
		String commandResultData = obdLink.sendDataAndReadResponse(commandData);
		CommandResult result = commandUnmarshaller.unmarshal(command, commandResultData);

		log.info("OBD Command result '{}'", result);

		command.setResult(result);
	}
}
