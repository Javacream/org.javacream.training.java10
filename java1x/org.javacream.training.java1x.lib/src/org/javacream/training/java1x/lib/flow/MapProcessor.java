package org.javacream.training.java1x.lib.flow;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

import org.javacream.training.java1x.lib.Log;


public class MapProcessor<T, R> extends SubmissionPublisher<R> implements Processor<T, R> {

	private final int indent;
	private final Function<? super T, ? extends R> function;
	private Subscription subscription;

	public MapProcessor(int indent, Function<? super T, ? extends R> function) {
		this.indent = indent;
		this.function = function;
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
		submit((R) function.apply(item));
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