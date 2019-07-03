package com.dawn.java.concurrency;

public class ThreadInfo {

	public static void getThreadInfo(Thread thread) {
		System.out.println("name=" + thread.getName());
		System.out.println("priority=" + thread.getPriority());
		System.out.println("daemon=" + thread.isDaemon());
		System.out.println("group=" + thread.getThreadGroup().toString());
		System.out.println("contextClassLoader=" + thread.getContextClassLoader().toString());
		System.out.println("tid=" + thread.getId());
		System.out.println("class=" + thread.getClass().toString());
		System.out.println("StackTrace=" + thread.getStackTrace().toString());
		System.out.println("state=" + thread.getState());
		System.out.println("UncaughtExceptionHandler=" + thread.getUncaughtExceptionHandler().toString());
//		System.out.println(thread.getAllStackTraces().toString());
//		System.out.println(thread.getDefaultUncaughtExceptionHandler().toString());
	}

	public static void getThreadGroupInfo(Thread thread) {
		ThreadGroup threadGroup = thread.getThreadGroup();
		System.out.println("name=" + threadGroup.getName());
	}

	public static void getThreadLocalInfo(Thread thread) {

	}

}
