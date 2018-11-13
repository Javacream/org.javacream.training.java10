package org.javacream.training.java1x.lib;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ConcurrentDemo {

	public static void main(String args[]) throws Exception {
		demoPythagoras();
		demoPythagorasVerbose();
		demoSimple();
		demoCompleteAsync();
		demoCompleteOnTimeout();
		demoOrTimeout();
		demoCompletedFuture();
		demoFailedFuture();
		demoDefaultExecutor();
		demoDelayedExecutor();
		demoNewIncompleteFuture();
		demoCompletedStage();
		demoFailedStage();
	}

	static void demoPythagoras() {
		Log.logMethodCall();
		CompletableFuture<Double> f1 = new CompletableFuture<>();
		CompletableFuture<Double> f2 = new CompletableFuture<>();
		CompletableFuture<Double> f3 = f1.thenApplyAsync(x -> x * x);
		CompletableFuture<Double> f4 = f2.thenApplyAsync(x -> x * x);
		CompletableFuture<Double> f5 = f3.thenCombine(f4, (x, y) -> x + y);
		CompletableFuture<Double> f6 = f5.thenApply(x -> Math.sqrt(x));
		f1.complete(3.0);
		f2.complete(4.0);
		try {
			double result = f6.get();
			System.out.println(result);
		}
		catch (InterruptedException | ExecutionException e) {
			System.out.println(e);
		}
	}

	static void demoPythagorasVerbose() {
		Log.logMethodCall();
		CompletableFuture<Double> f1 = new CompletableFuture<>();
		CompletableFuture<Double> f2 = new CompletableFuture<>();
		CompletableFuture<Double> f3 = f1.thenApplyAsync(x -> {
			Log.log(0, x + " * " + x + " => " + (x * x));
			Threading.sleep(1000);
			return x * x;
		});
		CompletableFuture<Double> f4 = f2.thenApplyAsync(x -> {
			Log.log(2, x + " * " + x + " => " + (x * x));
			Threading.sleep(1000);
			return x * x;
		});
		CompletableFuture<Double> f5 = f3.thenCombine(f4, (x, y) -> {
			Log.log(1, x + " + " + y + " => " + (x + y));
			Threading.sleep(1000);
			return x + y;
		});
		CompletableFuture<Double> f6 = f5.thenApply(x -> {
			Log.log(1, "Math.sqrt(" + x + ") ==> " + Math.sqrt(x));
			Threading.sleep(1000);
			return Math.sqrt(x);
		});
		Log.log(1, "complet 3.0");
		f1.complete(3.0);
		Threading.sleep(300);
		Log.log(1, "complet 4.0");
		f2.complete(4.0);
		try {
			double result = f6.get();
			Log.log(1, result);
		}
		catch (InterruptedException | ExecutionException e) {
			Log.log(1, e);
		}
	}

	static void demoSimple() throws InterruptedException, ExecutionException {
		Log.logMethodCall();
		CompletableFuture<Integer> f1 = new CompletableFuture<>();
		CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
		f1.complete(3);
		int result = f2.get();
		System.out.println(result);
	}

	static void demoCompleteAsync() throws InterruptedException, ExecutionException {
		Log.logMethodCall();
		CompletableFuture<Integer> f1 = new CompletableFuture<>();
		CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
		f1.completeAsync(() -> 3);

		int result = f2.get();
		System.out.println(result);
	}

	static void demoCompleteOnTimeout() throws InterruptedException, ExecutionException {
		Log.logMethodCall();
		CompletableFuture<Integer> f1 = new CompletableFuture<>();
		CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> {
			sleep(2000);
			return x * x;
		});
		CompletableFuture<Integer> f3 = f2.completeOnTimeout(-1, 1000, TimeUnit.MILLISECONDS);
		System.out.println(f3 == f2);

		f1.complete(3);
		int result = f3.get();
		System.out.println(result);
	}

	static void demoOrTimeout() {
		Log.logMethodCall();
		CompletableFuture<Integer> f1 = new CompletableFuture<>();
		CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> {
			sleep(2000);
			return x * x;
		});
		CompletableFuture<Integer> f3 = f2.orTimeout(1000, TimeUnit.MILLISECONDS);
		System.out.println(f3 == f2);
		f1.complete(3);
		try {
			int result = f3.get();
			System.out.println(result);
		}
		catch (ExecutionException | InterruptedException e) {
			System.out.println(e);
		}
	}

	static void demoCompletedFuture() throws InterruptedException, ExecutionException {
		Log.logMethodCall();
		CompletableFuture<Integer> f1 = CompletableFuture.completedFuture(3); // java
		CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
		int result = f2.get();
		System.out.println(result);
	}

	static void demoFailedFuture() {
		Log.logMethodCall();
		CompletableFuture<Integer> f1 = CompletableFuture.failedFuture(new RuntimeException("Water in drive a:"));
		CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
		try {
			int result = f2.get();
			System.out.println(result);
		}
		catch (InterruptedException | ExecutionException e) {
			System.out.println(e);
		}
	}

	static void demoCompletedStage() throws InterruptedException, ExecutionException {
		Log.logMethodCall();
		CompletionStage<Integer> f1 = CompletableFuture.completedStage(3);
		CompletionStage<Integer> f2 = f1.thenApplyAsync(x -> x * x);
		f2.whenComplete((Integer v, Throwable t) -> System.out.println(v + " " + t));
	}

	static void demoFailedStage() throws InterruptedException, ExecutionException {
		Log.logMethodCall();
		CompletionStage<Integer> f1 = CompletableFuture.failedStage(new RuntimeException("ex"));
		CompletionStage<Integer> f2 = f1.thenApplyAsync(x -> x * x);
		f2.whenComplete((Integer v, Throwable t) -> System.out.println(v + " " + t));
	}

	static void demoDefaultExecutor() {
		Log.logMethodCall();
		CompletableFuture<Integer> f = new CompletableFuture<>();
		Executor executor = f.defaultExecutor();
		System.out.println(executor);
	}

	static void demoDelayedExecutor() throws InterruptedException, ExecutionException {
		Log.logMethodCall();
		CompletableFuture<Integer> f1 = new CompletableFuture<>();
		CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
		f1.completeAsync(() -> 3, CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));
		int result = f2.get();
		System.out.println(result);
	}

	static class MyFuture<T> extends CompletableFuture<T> {
		static class MyExecutor implements Executor {
			@Override
			public void execute(Runnable command) {
				System.out.println("MyExecutor.execute(" + command + ")");
				new Thread(command).start();
			}
		};

		@SuppressWarnings("unchecked")
		@Override
		public CompletableFuture<T> newIncompleteFuture() {
			System.out.println("MyFuture.newIncompleteFuture()");
			return new MyFuture<T>();
		}

		@SuppressWarnings("unchecked")
		@Override
		public <R> MyFuture<R> thenApplyAsync(Function<? super T, ? extends R> function) {
			sleep(10);
			return (MyFuture<R>) super.thenApplyAsync(function, new MyExecutor());
		}
	}

	static void demoNewIncompleteFuture() throws InterruptedException, ExecutionException {
		Log.logMethodCall();
		CompletableFuture<Integer> f1 = new MyFuture<>();
		System.out.println(f1.getClass().getName());
		CompletableFuture<Integer> f2 = f1.thenApplyAsync(x -> x * x);
		System.out.println(f2.getClass().getName());
		f1.complete(3);
		int result = f2.get();
		System.out.println(result);
	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}


