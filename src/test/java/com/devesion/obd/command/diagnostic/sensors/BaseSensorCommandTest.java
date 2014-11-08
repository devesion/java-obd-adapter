package com.devesion.obd.command.diagnostic.sensors;

import com.devesion.obd.shared.ObdNumberedEnum;

import static org.fest.assertions.api.Assertions.assertThat;

abstract class BaseSensorCommandTest {

	protected void testCommandHasProperPid(SensorCommand sut, SensorCommandPids pid) {
		// given

		// when
		ObdNumberedEnum mode = sut.getPid();

		// then
		assertThat(mode).isEqualTo(pid);
	}
}
