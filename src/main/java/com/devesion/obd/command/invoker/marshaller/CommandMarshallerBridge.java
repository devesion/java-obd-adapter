package com.devesion.obd.command.invoker.marshaller;

import com.devesion.obd.command.ObdCommand;
import com.devesion.obd.command.ObdCommandVisitor;
import com.devesion.obd.command.diagnostic.DiagnosticCommand;
import com.devesion.obd.command.protocol.ProtocolCommand;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Represents OBD command marshaller bridge implementation.
 */
public class CommandMarshallerBridge implements CommandMarshaller {

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
		public void visit(ProtocolCommand command) {
			concreteMarshaller = new ProtocolCommandMarshaller();
		}

		@Override
		public void visit(DiagnosticCommand command) {
			concreteMarshaller = new DiagnosticCommandMarshaller();
		}
	}
}
