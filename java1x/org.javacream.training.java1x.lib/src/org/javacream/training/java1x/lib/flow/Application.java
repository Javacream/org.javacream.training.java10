package org.javacream.training.java1x.lib.flow;

import java.util.concurrent.SubmissionPublisher;

import org.javacream.training.java1x.lib.Log;
import org.javacream.training.java1x.lib.Threading;

public class Application {
	public static void main(String[] args) throws Exception {
		demoMapProcessor();
		demoFilterProcessor();
		demoMapFilterProcessor();
	}

	static void demoMapProcessor() {
		Log.logMethodCall();

		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

		MapProcessor<String, Integer> processor = new MapProcessor<>(1, s -> s.length());
		publisher.subscribe(processor);

		MySubscriber<Integer> subscriber = new MySubscriber<>(2, 100);
		processor.subscribe(subscriber);

		submit(publisher);
	}

	static void demoFilterProcessor() {
		Log.logMethodCall();

		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

		FilterProcessor<String> processor = new FilterProcessor<>(1, s -> s.length() >= 4);
		publisher.subscribe(processor);

		MySubscriber<String> subscriber = new MySubscriber<>(2, 100);
		processor.subscribe(subscriber);

		submit(publisher);
	}

	static void demoMapFilterProcessor() {
		Log.logMethodCall();

		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

		MapProcessor<String, Integer> processor1 = new MapProcessor<>(1, s -> s.length());
		publisher.subscribe(processor1);

		FilterProcessor<Integer> processor2 = new FilterProcessor<>(2, i -> i >= 4);
		processor1.subscribe(processor2);

		MySubscriber<Integer> subscriber = new MySubscriber<>(3, 100);
		processor2.subscribe(subscriber);

		submit(publisher);
	}

	static private void submit(SubmissionPublisher<String> publisher) {
		String[] colors = new String[] { "red", "green", "blue" };
		for (String color : colors) {
			Log.log(0, "submit " + color);
			publisher.submit(color);
		}

		Threading.sleep(1000);
		Log.log(0, "close");
		publisher.close();
	}

}