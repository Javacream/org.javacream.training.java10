package org.javacream.training.java10.helloworld.actor;

import org.javacream.training.java10.helloworld.api.HelloWorld;
import org.javacream.training.java10.helloworld.dao.api.data.HelloWorldResponse;

public class HelloWorldActor {

	public static void main(String[] args) {
		HelloWorld hw = HelloWorld.create();
		
		HelloWorldResponse response = hw.sayHello();
		System.out.println(response.getMessage());
	}

}
