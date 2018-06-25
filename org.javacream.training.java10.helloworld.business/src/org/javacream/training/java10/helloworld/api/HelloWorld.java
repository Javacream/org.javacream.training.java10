package org.javacream.training.java10.helloworld.api;

import org.javacream.training.java10.helloworld.dao.api.data.HelloWorldResponse;
import org.javacream.training.java10.helloworld.impl.HelloWorldImpl;

public interface HelloWorld {

	HelloWorldResponse sayHello();
	
	public static HelloWorld create() {
		return new HelloWorldImpl();
	}
}
