package org.javacream.training.java1x.echo.impl;

import org.javacream.training.java1x.echo.api.EchoService;

public class EchoServiceImpl implements EchoService {

    {
	System.out.println("CREATING ECHOSERVICEIMPL " + this);
    }

    @Override
    public String echo(String message) {
	return new StringBuilder(message).reverse().toString();
    }

    public String echoIntern(String message) {
	return message;
    }

}
