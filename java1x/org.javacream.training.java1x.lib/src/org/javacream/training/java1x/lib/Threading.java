package org.javacream.training.java1x.lib;

public class Threading {
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}
		catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
