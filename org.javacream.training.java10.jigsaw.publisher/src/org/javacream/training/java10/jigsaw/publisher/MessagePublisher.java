package org.javacream.training.java10.jigsaw.publisher;


import java.util.ServiceLoader;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

public class MessagePublisher {
	private SubmissionPublisher<String> publisher;

	{
		Executor executor = Executors.newFixedThreadPool(2);
		publisher = new SubmissionPublisher<>(executor, 100);
		ServiceLoader<StringSubscriber> loader = ServiceLoader.load(StringSubscriber.class);
		loader.forEach(publisher::subscribe);
	}
	public int submit(String message) {
		return publisher.submit(message);
	}


}
