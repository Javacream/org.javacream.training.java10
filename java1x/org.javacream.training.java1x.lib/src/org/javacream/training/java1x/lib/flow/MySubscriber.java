package org.javacream.training.java1x.lib.flow;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import org.javacream.training.java1x.lib.Log;
import org.javacream.training.java1x.lib.Threading;

public class MySubscriber<T> implements Subscriber<T> {
	
	private final CountDownLatch done = new CountDownLatch(1);

	private final int indent;
	private final int sleeptime;
	private Subscription subscription;

	public MySubscriber(int indent, int sleeptime) {
		this.indent = indent;
		this.sleeptime = sleeptime;
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
//		if (item.equals(45))
//			this.subscription.cancel();
	    Threading.sleep(this.sleeptime);
    	this.subscription.request(1); 
	}

	@Override
	public void onError(Throwable t) {
		Log.log(this.indent, "onError " + t);
		done.countDown();
	}

	@Override
	public void onComplete() {
		Log.log(this.indent, "onComplete");
		done.countDown();
	}
	
	public void await() {
		try {
			done.await();
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}