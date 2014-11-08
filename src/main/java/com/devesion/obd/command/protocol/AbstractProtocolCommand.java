package com.devesion.obd.command.protocol;

import com.devesion.obd.command.AbstractCommand;
import com.devesion.obd.command.ObdCommandVisitor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Supertype for every Protocol Command.
 */
@ToString
@EqualsAndHashCode(callSuper = true)
abstract class AbstractProtocolCommand extends AbstractCommand implements ProtocolCommand {

	@Override
	public void accept(ObdCommandVisitor visitor) {
		visitor.visit(this);
	}
}
