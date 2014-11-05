package com.devesion.obd.command.diagnostic.info;

import com.devesion.obd.command.diagnostic.DiagnosticCommandPid;
import lombok.Getter;

public enum InfoCommandPids implements DiagnosticCommandPid {
	ONE(1);

	@Getter
	private int number;

	InfoCommandPids(int number) {
		this.number = number;
	}
}