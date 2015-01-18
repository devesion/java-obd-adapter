package com.devesion.commons.obd;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public final class TestSupport {

	private static ThreadLocalRandom random = ThreadLocalRandom.current();

	private TestSupport() {
		throw new AssertionError();
	}

	public static String getRandomString() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString();
	}

	public static boolean getRandomBoolean() {
		return random.nextBoolean();
	}

	public static int getRandomInt() {
		return Math.abs(random.nextInt());
	}

	public static int getRandomInt(int max) {
		return Math.abs(random.nextInt(0, max));
	}

	public static long getRandomLong() {
		return Math.abs(random.nextLong());
	}

	public static int getRandomIntByte() {
		return getRandomInt(255);
	}

	public static class InputStreamAnswer implements Answer {

		private final byte[] rawData;
		private int curIndex = 0;

		public InputStreamAnswer(String streamData) {
			this.rawData = streamData.getBytes();
		}

		@Override
		public Object answer(InvocationOnMock invocation) throws Throwable {
			return rawData[curIndex++];
		}
	}
}
