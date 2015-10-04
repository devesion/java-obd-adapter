package com.autonalyzer.adapter.android;

import com.autonalyzer.adapter.android.domain.DiagnosticStatus;
import com.autonalyzer.adapter.android.domain.DiagnosticStatusFactory;
import com.autonalyzer.adapter.android.infrastructure.DefaultDiagnosticStatusFactory;
import com.google.common.base.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Launcher {

	public static void main(String[] args) {
		while (true) {
			DiagnosticStatusFactory statusFactory = new DefaultDiagnosticStatusFactory();
			Optional<DiagnosticStatus> status = statusFactory.getCurrentStatus();
			log.info("status {}", status);
		}
	}
}
