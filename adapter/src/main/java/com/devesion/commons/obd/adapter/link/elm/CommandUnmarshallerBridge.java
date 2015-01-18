package com.devesion.commons.obd.adapter.link.elm;

import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.command.ObdCommandVisitor;
import com.devesion.commons.obd.adapter.command.at.AtCommand;
import com.devesion.commons.obd.adapter.command.diagnostic.DiagnosticCommand;
import com.devesion.commons.obd.adapter.command.CommandResult;
import com.devesion.commons.obd.adapter.link.CommandUnmarshaller;
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
