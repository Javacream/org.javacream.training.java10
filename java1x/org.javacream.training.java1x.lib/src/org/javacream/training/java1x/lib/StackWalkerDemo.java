package org.javacream.training.java1x.lib;

import java.lang.StackWalker.StackFrame;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Alpha {
    static void alpha(Runnable runnable) {
	Beta.beta(runnable);
    }
}

class Beta {
    static void beta(Runnable runnable) {
	Gamma.gamma(runnable);
    }
}

class Gamma {
    static void gamma(Runnable runnable) {
	runnable.run();
    }
}

public class StackWalkerDemo {

    public static void main(String args[]) {
	demoForEach();
//	demoWalk();
//	demoWalkIllegal();
//	demoWithClasses();
//	demoOptions();
//	demoLimit();
//	demoSkip();
//	demoFilterClasses();
//	demoCallerClass();
//	demoStackFrame();
//	demoPerformance();
    }

    static void demoForEach() {
	Log.logMethodCall();
	Alpha.alpha(() -> {
	    StackWalker walker = StackWalker.getInstance();
	    walker.forEach((StackFrame f) -> System.out.println(f));
	});
    }

    static void demoWalk() {
	Log.logMethodCall();
	Alpha.alpha(() -> {
	    StackWalker walker = StackWalker.getInstance();
	    List<StackFrame> stack = walker.walk((Stream<StackFrame> s) -> s.collect(Collectors.toList()));
	    for (StackFrame f : stack) {
		System.out.println(f);
	    }
	});
    }

    static void demoWalkIllegal() {
	Log.logMethodCall();
	try {
	    Alpha.alpha(() -> {
		StackWalker walker = StackWalker.getInstance();
		Stream<StackFrame> stream = walker.walk(s -> s);
		stream.forEach(f -> System.out.println(f));
	    });
	} catch (Exception e) {
	    System.out.println(e);
	    // java.lang.IllegalStateException: This stack stream is not valid for walking.
	}
    }

    static void demoWithClasses() {
	Log.logMethodCall();
	Alpha.alpha(() -> {
	    StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
	    walker.forEach(f -> {
		System.out.println(f);
		System.out.println("\t" + f.getDeclaringClass());
	    });
	});
    }

    static void demoOptions() {
	Log.logMethodCall();
	Alpha.alpha(() -> {
	    StackWalker walker = StackWalker.getInstance(Set.of(StackWalker.Option.RETAIN_CLASS_REFERENCE,
		    StackWalker.Option.SHOW_HIDDEN_FRAMES, StackWalker.Option.SHOW_REFLECT_FRAMES));
	    walker.forEach(f -> System.out.println(f));
	});
    }

    static void demoLimit() {
	Log.logMethodCall();
	Alpha.alpha(() -> {
	    StackWalker walker = StackWalker.getInstance();
	    // StackWalker walker = StackWalker.getInstance(new
	    // HashSet<StackWalker.Option>(), 2);
	    List<StackFrame> stack = walker.walk(s -> s.limit(2).collect(Collectors.toList()));
	    for (StackFrame f : stack) {
		System.out.println(f);
	    }
	});
    }

    static void demoSkip() {
	Log.logMethodCall();
	Alpha.alpha(() -> {
	    StackWalker walker = StackWalker.getInstance();
	    List<StackFrame> stack = walker.walk(s -> s.skip(2).collect(Collectors.toList()));
	    for (StackFrame f : stack) {
		System.out.println(f);
	    }
	});
    }

    static void demoFilterClasses() {
	Log.logMethodCall();
	Alpha.alpha(() -> {
	    StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
	    List<StackFrame> stack = walker
		    .walk(s -> s.filter(f -> f.getDeclaringClass() == Alpha.class).collect(Collectors.toList()));
	    for (StackFrame f : stack) {
		System.out.println(f);
	    }
	});
    }

    static void demoCallerClass() {
	Log.logMethodCall();
	Alpha.alpha(() -> {
	    StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
	    Class<?> cls = walker.getCallerClass();
	    System.out.println(cls);
	});
    }

    static void demoStackFrame() {
	Log.logMethodCall();
	Alpha.alpha(() -> {
	    StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
	    walker.forEach(f -> print(f));
	});
    }

    static void print(StackFrame f) {
	System.out.println(f);
	System.out.println("\tClassName      = " + f.getClassName());
	System.out.println("\tDeclaringClass = " + f.getDeclaringClass());
	System.out.println("\tMethodName     = " + f.getMethodName());
	System.out.println("\tFileName       = " + f.getFileName());
	System.out.println("\tLineNumber     = " + f.getLineNumber());
    }

    static void demoPerformance() {
	Log.logMethodCall();
	System.out.println("running...");
	Alpha.alpha(() -> {
	    final int N = 100000;
	    long n1 = 0;
	    long n2 = 0;
	    long n3 = 0;
	    long duration1 = 0;
	    long duration2 = 0;
	    long duration3 = 0;
	    for (int i = 0; i < N; i++) {
		{
		    long start = System.nanoTime();
		    StackWalker walker = StackWalker.getInstance();
		    List<StackFrame> stack = walker.walk(s -> s.limit(2).collect(Collectors.toList()));
		    n1 += stack.size();
		    duration1 += (System.nanoTime() - start);
		}
		{
		    long start = System.nanoTime();
		    StackWalker walker = StackWalker.getInstance();
		    long count = walker.walk(s -> s.limit(2).count());
		    n2 += count;
		    duration2 += (System.nanoTime() - start);
		}
		{
		    long start = System.nanoTime();
		    StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		    n3 += elements.length;
		    duration3 += (System.nanoTime() - start);
		}
	    }
	    System.out.println(n1);
	    System.out.println(n2);
	    System.out.println(n3);
	    System.out.println(duration1);
	    System.out.println(duration2);
	    System.out.println(duration3);
	});
    }
}
