package com.devesion.obd.command.invoker;

import com.devesion.obd.link.ObdLink;
import com.devesion.obd.command.ObdCommand;
import lombok.extern.slf4j.Slf4j;

/**
 * Responsible for invoking OBD Commands.
 */
@Slf4j
public class CommandInvoker {

	private ObdLink obdLink;
	private CommandMarshaller commandMarshaller = new DefaultCommandMarshaller();
	private CommandUnmarshaller commandUnmarshaller = new DefaultCommandUnmarshaller();

	public CommandInvoker(ObdLink obdLink) {
		this.obdLink = obdLink;
	}

	public void invoke(ObdCommand command) {
		log.info("invoking OBD Command '{}'", command);
		String commandData = commandMarshaller.marshal(command);

		log.debug("sending data");
		log.debug("data " + commandData);
		obdLink.sendData(commandData);
		log.debug("data sent, waiting for result");

		String commandResultData = obdLink.readData();
		CommandResult result = commandUnmarshaller.unmarshal(commandResultData);
		log.info("OBD Command result '{}'", result);

		command.setResult(result);
	}
}
