package org.javacream.training.java10.helloworld.impl;

import org.javacream.training.java10.helloworld.api.HelloWorld;
import org.javacream.training.java10.helloworld.dao.api.HelloWorldDataAccess;
import org.javacream.training.java10.helloworld.dao.api.data.HelloWorldResponse;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public HelloWorldResponse sayHello() {
		return HelloWorldDataAccess.create().getMessage();
	}

}
