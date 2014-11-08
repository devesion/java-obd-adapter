package com.devesion.obd.command.invoker.marshaller;

import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.command.diagnostic.DiagnosticCommand;
import com.devesion.obd.shared.HexTools;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class DiagnosticCommandMarshaller extends AbstractCommandMarshaller {

	@Override
	public String marshal(ObdCommand command) {
		DiagnosticCommand diagnosticCommand = (DiagnosticCommand) command;
		String commandMnemonic = HexTools.toHexString(diagnosticCommand.getMode());
		String commandOperands = HexTools.toHexString(diagnosticCommand.getPid());
		return buildResponse(commandMnemonic, commandOperands);
	}
}
