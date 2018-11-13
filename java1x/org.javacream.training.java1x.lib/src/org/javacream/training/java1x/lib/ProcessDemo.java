package org.javacream.training.java1x.lib;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessDemo {

    public static void main(String[] args) throws Exception {
	demoProcessHandle();
	demoAllProcesses();
	demoExec();
//		demoExecWaitFor();
//		demoExecFuture();
//		demoDestroy();

    }

    static void demoProcessHandle() {
	Log.logMethodCall();
	ProcessHandle handle = ProcessHandle.current();
	printProcessHandle(handle);
	ProcessHandle.Info info = handle.info();
	printProcessHandleInfo(info);
    }

    static void demoAllProcesses() throws Exception {
	Log.logMethodCall();
	Stream<ProcessHandle> handles = ProcessHandle.allProcesses();
	handles.filter(h -> filterJavaAndEclipse(h)).forEach(h -> printProcessHandle(h));
    }

    private static boolean filterJavaAndEclipse(ProcessHandle handle) {
	ProcessHandle.Info info = handle.info();
	Optional<String> command = info.command();
	if (!command.isPresent())
	    return false;
	return command.get().contains("java") || command.get().contains("eclipse");
    }

    static void demoExec() throws Exception {
	Log.logMethodCall();
	// Runtime.getRuntime().exec(new String[] { "calc.exe" });
	Process process = new ProcessBuilder("calc.exe").start();
	ProcessHandle.Info info = process.info();
	printProcessHandleInfo(info);
	Optional<ProcessHandle> handle = ProcessHandle.of(process.pid());
	if (handle.isPresent())
	    printProcessHandle(handle.get());
    }

    static void demoExecWaitFor() throws Exception {
	Log.logMethodCall();
	Process process = new ProcessBuilder("calc.exe").start();
	System.out.println(process);
	System.out.println("waiting...");
	int result = process.waitFor();
	System.out.println("Finished: " + result);
    }

    static void demoExecFuture() throws Exception {
	Log.logMethodCall();
	Process process = new ProcessBuilder("calc.exe").start();
	System.out.println(process);
	final CompletableFuture<Process> future = process.onExit();
	System.out.println("waiting...");
	Process p = future.get();
	System.out.println(p);
	System.out.println("Finished");
    }

    static void demoDestroy() throws Exception {
	Log.logMethodCall();
	Process process = new ProcessBuilder("calc.exe").start();
	Optional<ProcessHandle> handle = ProcessHandle.of(process.pid());
	Thread.sleep(2000);
	if (handle.isPresent()) {
	    boolean done = handle.get().destroy();
	    System.out.println("Destroyed: " + done);
	}
    }

    private static void printProcessHandle(ProcessHandle handle) {
	System.out.println("ProcessHandle");
	System.out.println("\tpid              = " + handle.pid());
	System.out.println("\tisAlive          = " + handle.isAlive());
	System.out.println("\tparent           = " + handle.parent());
	System.out.println("\tchildren         = " + handle.children().collect(Collectors.toList()));
	System.out.println("\tdescendants      = " + handle.descendants().collect(Collectors.toList()));
	System.out.println("\tsupports...      = " + handle.supportsNormalTermination());
    }

    private static void printProcessHandleInfo(ProcessHandle.Info info) {
	System.out.println("ProcessHandle.Info");
	System.out.println("\tcommand          = " + info.command());
	System.out.println("\tcommandLine      = " + info.commandLine());
	System.out.println("\targuments        = " + info.arguments());
	System.out.println("\tstartInstant     = " + info.startInstant());
	System.out.println("\ttotalCpuDuration = " + info.totalCpuDuration());
	System.out.println("\tuser             = " + info.user());
    }
}