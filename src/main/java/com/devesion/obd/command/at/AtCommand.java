package com.devesion.obd.command.at;

import com.devesion.obd.command.ObdCommand;

public interface AtCommand extends ObdCommand {

	String getOperands();
}
