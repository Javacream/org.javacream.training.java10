package org.javacream.training.java1x.echoactor;

import org.javacream.training.java1x.echo.api.EchoService;
import org.javacream.training.java1x.echo.api.EchoServiceBuilder;

public class SimpleEchoActor {

    public static void main(String[] args) throws Exception{
	EchoService echoService = EchoServiceBuilder.create();
	System.out.println(echoService.getClass().getName());
	System.out.println("echoService echoes: " + echoService.echo("Hello"));
//	// Kein Zugriff auch über Reflection!
	System.out.println(echoService.getClass().getMethod("echo", String.class).invoke(echoService, "Access method echo from EchoService"));
	EchoService es2 = echoService.getClass().getConstructor().newInstance();
	es2.echo("echo using instance created by reflection");
	System.out.println(echoService.getClass().getMethod("echoIntern", String.class).invoke(echoService, "Access method echoIntern"));
    }
}
