package com.devesion.commons.obd.link.elm;

import com.devesion.commons.obd.command.ObdCommand;
import com.devesion.commons.obd.command.ObdCommandVisitor;
import com.devesion.commons.obd.command.at.AtCommand;
import com.devesion.commons.obd.command.diagnostic.DiagnosticCommand;
import com.devesion.commons.obd.link.CommandMarshaller;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Represents OBD command marshaller bridge implementation.
 */
class CommandMarshallerBridge implements CommandMarshaller {

	@Override
	public String marshal(ObdCommand command) {
		MarshallerFactoryVisitor marshallerFactoryVisitor = new MarshallerFactoryVisitor();
		command.accept(marshallerFactoryVisitor);
		CommandMarshaller concreteMarshaller = marshallerFactoryVisitor.getConcreteMarshaller();
		return concreteMarshaller.marshal(command);
	}

	private class MarshallerFactoryVisitor implements ObdCommandVisitor {

		@Getter(AccessLevel.PRIVATE)
		private CommandMarshaller concreteMarshaller;

		@Override
		public void visit(AtCommand command) {
			concreteMarshaller = new AtCommandMarshaller();
		}

		@Override
		public void visit(DiagnosticCommand command) {
			concreteMarshaller = new DiagnosticCommandMarshaller();
		}
	}
}
