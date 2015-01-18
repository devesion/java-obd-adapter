package com.devesion.commons.obd.adapter.command.at;

import com.devesion.commons.obd.adapter.command.AbstractCommand;
import com.devesion.commons.obd.adapter.command.ObdCommandVisitor;
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
