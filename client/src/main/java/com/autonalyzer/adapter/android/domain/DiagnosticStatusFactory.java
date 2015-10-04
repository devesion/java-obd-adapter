package com.autonalyzer.adapter.android.domain;

import com.google.common.base.Optional;

public interface DiagnosticStatusFactory {

	Optional<DiagnosticStatus> getCurrentStatus();
}
