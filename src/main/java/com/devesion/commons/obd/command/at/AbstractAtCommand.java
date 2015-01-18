package com.devesion.commons.obd.command.at;

import com.devesion.commons.obd.command.AbstractCommand;
import com.devesion.commons.obd.command.ObdCommandVisitor;
import lombok.EqualsAndHashCode;

/**
 * Supertype for every AT Command.
 */
@EqualsAndHashCode(callSuper = true)
abstract class AbstractAtCommand extends AbstractCommand implements AtCommand {

	@Override
	public void accept(ObdCommandVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("AbstractAtCommand{");
		sb.append("operands='").append(getOperands()).append("'}");
		return sb.toString();
	}
}
