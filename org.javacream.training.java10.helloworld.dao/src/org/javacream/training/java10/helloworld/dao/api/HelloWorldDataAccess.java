package org.javacream.training.java10.helloworld.dao.api;

import org.javacream.training.java10.helloworld.dao.api.data.HelloWorldResponse;
import org.javacream.training.java10.helloworld.dao.impl.HelloWorldDataAccessImpl;

public interface HelloWorldDataAccess {

	HelloWorldResponse getMessage();

	public static HelloWorldDataAccess create() {
		return new HelloWorldDataAccessImpl();
	}
}
