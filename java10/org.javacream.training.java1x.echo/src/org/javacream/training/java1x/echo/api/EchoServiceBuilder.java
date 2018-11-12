package org.javacream.training.java1x.echo.api;

import org.javacream.training.java1x.echo.impl.EchoServiceImpl;

public class EchoServiceBuilder
{

	public static EchoService create() {
		return new EchoServiceImpl();
	}
}
