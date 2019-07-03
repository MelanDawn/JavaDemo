package com.dawn.java.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCreation {

	public static void createNewThread() {
		new CreationByThread().start();

		new Thread(new CreationByRunnable()).start();

//		public interface RunnableFuture<V> extends Runnable, Future<V> {
//		public class FutureTask<V> implements RunnableFuture<V> {
		FutureTask<Integer> futureTask = new FutureTask<>(new CreationByCallable());
		new Thread(futureTask).start();
		try {
			// get() 会阻塞线程，直到线程执行结束返回后再执行其他内容
			System.out.println("CreationByCallable result = " + futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("ThreadCreation end");
	}

	// 继承 Thread 类，重写run方法
	private static class CreationByThread extends Thread {
		@Override
		public void run() {
			System.out.println("CreationByThread is running");
		}
	}

	// 实现 Runnable 接口，实现run方法
	private static class CreationByRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("CreationByRunnable is running");
		}
	}

	// 实现 Callable 接口，实现call方法
	private static class CreationByCallable implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			System.out.println("CreationByCallable is running");
			Thread.sleep(2000);
			return 1;
		}
	}

}
