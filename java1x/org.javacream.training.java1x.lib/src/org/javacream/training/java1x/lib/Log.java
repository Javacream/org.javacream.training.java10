package org.javacream.training.java1x.lib;

import java.util.List;
import java.util.stream.Collectors;

public class Log {

    private static Object lock = new Object();

    public static void logMethodCall() {
	final String line = "+---------------------------------------";
	final List<StackWalker.StackFrame> stack = StackWalker.getInstance()
		.walk(s -> s.limit(2).collect(Collectors.toList()));
	System.out.println(" ");
	System.out.println(line);
	System.out.println("| " + stack.get(1).getMethodName());
	System.out.println(line);
    }

    public static void log(Object obj) {
	synchronized (lock) {
	    System.out.println(obj);
	}
    }

    public static void log(int indent, Object obj) {
	synchronized (lock) {
	    while (indent-- > 0)
		System.out.print("    ");
	    System.out.print("[" + Thread.currentThread().getId() + "] ");
	    log(obj);
	}
    }
}
