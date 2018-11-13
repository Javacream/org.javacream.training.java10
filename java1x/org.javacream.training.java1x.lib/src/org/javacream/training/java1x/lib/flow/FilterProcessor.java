package org.javacream.training.java1x.lib.flow;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Predicate;

import org.javacream.training.java1x.lib.Log;


public class FilterProcessor<T> extends SubmissionPublisher<T> implements Processor<T, T> {

	private final int indent;
	private final Predicate<? super T> predicate;
	private Subscription subscription;

	public FilterProcessor(int indent, Predicate<? super T> predicate) {
		this.indent = indent;
		this.predicate = predicate;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		Log.log(this.indent, "onSubscribe " + subscription);
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(T item) {
		Log.log(this.indent, "onNext " + item);
		if (predicate.test(item))
			this.submit(item);
		subscription.request(1);
	}

	@Override
	public void onError(Throwable t) {
		Log.log(this.indent, "onError");
	}

	@Override
	public void onComplete() {
		Log.log(this.indent, "onComplete");
		this.close();
	}
}