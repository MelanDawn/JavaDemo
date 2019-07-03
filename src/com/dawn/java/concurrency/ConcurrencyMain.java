package com.dawn.java.concurrency;

public class ConcurrencyMain {

	public static void main(String[] args) {
		// 线程信息
		ThreadInfo.getThreadInfo(Thread.currentThread());
		System.out.println();

		// 三种创建新线程的方法
		ThreadCreation.createNewThread();
		System.out.println();
	}
}
