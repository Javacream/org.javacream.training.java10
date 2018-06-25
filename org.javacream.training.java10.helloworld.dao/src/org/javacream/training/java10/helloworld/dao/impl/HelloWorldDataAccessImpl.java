package org.javacream.training.java10.helloworld.dao.impl;

import org.javacream.training.java10.helloworld.dao.api.HelloWorldDataAccess;
import org.javacream.training.java10.helloworld.dao.api.data.HelloWorldResponse;

public class HelloWorldDataAccessImpl implements HelloWorldDataAccess {

	@Override
	public HelloWorldResponse getMessage() {
		return new HelloWorldResponse("Hello World from DAO");
		
	}
	
	public static void main(String[] args) {
		System.out.println(new HelloWorldDataAccessImpl().getMessage());
	}

}
