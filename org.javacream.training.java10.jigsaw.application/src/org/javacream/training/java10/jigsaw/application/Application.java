package org.javacream.training.java10.jigsaw.application;

import java.util.List;

import org.javacream.training.java10.jigsaw.publisher.MessagePublisher;

public class Application {

	public static void main(String[] args) {
		MessagePublisher messagePublisher = new MessagePublisher();
		List.of("A", "H", "C").forEach(messagePublisher::submit);
	}

}
