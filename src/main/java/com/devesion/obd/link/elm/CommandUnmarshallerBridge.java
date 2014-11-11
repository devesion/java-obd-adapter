package com.devesion.obd.link.elm;

import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.command.ObdCommandVisitor;
import com.devesion.obd.command.at.AtCommand;
import com.devesion.obd.command.diagnostic.DiagnosticCommand;
import com.devesion.obd.command.CommandResult;
import com.devesion.obd.link.CommandUnmarshaller;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Represents OBD command unmarshaller bridge implementation.
 */
class CommandUnmarshallerBridge implements CommandUnmarshaller {

	@Override
	public CommandResult unmarshal(ObdCommand command, String responseData) {
		UnmarshallerFactoryVisitor unmarshallerFactoryVisitor = new UnmarshallerFactoryVisitor();
		command.accept(unmarshallerFactoryVisitor);
		CommandUnmarshaller concreteUnmarshaller = unmarshallerFactoryVisitor.getConcreteUnmarshaller();
		return concreteUnmarshaller.unmarshal(command, responseData);
	}

	private class UnmarshallerFactoryVisitor implements ObdCommandVisitor {

		@Getter(AccessLevel.PRIVATE)
		private CommandUnmarshaller concreteUnmarshaller;

		@Override
		public void visit(AtCommand command) {
			concreteUnmarshaller = new AtCommandUnmarshaller();
		}

		@Override
		public void visit(DiagnosticCommand command) {
			concreteUnmarshaller = new DiagnosticCommandUnmarshaller();
		}
	}
}
