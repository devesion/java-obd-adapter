package com.devesion.obd.command.at;

import com.devesion.obd.command.AbstractCommand;
import com.devesion.obd.command.ObdCommandVisitor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Supertype for every AT Command.
 */
@ToString
@EqualsAndHashCode(callSuper = true)
abstract class AbstractAtCommand extends AbstractCommand implements AtCommand {

	@Override
	public void accept(ObdCommandVisitor visitor) {
		visitor.visit(this);
	}
}
