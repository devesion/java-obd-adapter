package com.devesion.commons.obd.adapter.command.diagnostic;

import com.devesion.commons.obd.adapter.command.ObdCommand;
import com.devesion.commons.obd.adapter.shared.ObdNumberedEnum;

public interface DiagnosticCommand extends ObdCommand {

	ObdNumberedEnum getMode();

	ObdNumberedEnum getPid();
}
