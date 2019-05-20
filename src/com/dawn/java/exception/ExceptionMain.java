package com.dawn.java.exception;

public class ExceptionMain {

	public static void main(String[] args) {
		// 被调用方法直接抛出发生的异常
		try {
			checkSex();
		} catch (SexException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000);
			System.out.println();
			System.out.println();
		} catch (Exception e) {
			// nothing to do.
		}

		// 被调用的方法捕获异常，抛一个新建异常，形成异常链
		try {
			checkSex2();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000);
			System.out.println();
			System.out.println();
		} catch (Exception e) {
			// nothing to do.
		}

		try {
			checkSex3();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void checkSex3() throws Exception {
		try {
			checkSex2();
		} catch (IllegalStateException e) {
			throw new Exception("抛出新异常3，添加到异常链", e);
		}
	}

	public static void checkSex2() throws IllegalStateException {
		try {
			checkSex();
		} catch (SexException e) {
			throw new IllegalStateException("抛出新异常2，添加到异常链", e);
		}
	}

	public static void checkSex() throws SexException {
		final int MALE = 1;
		final int FEMALE = 0;

		int[] sexs = { 0, 1, 2, 1 };
		for (int sex : sexs) {
			if (sex != MALE && sex != FEMALE) {
				throw new SexException("unknown sex: " + sex);
			}
//			System.out.println("valid sex: " + sex);
		}
	}

//	com.dawn.java.exception.SexException: unknown sex: 2
//		at com.dawn.java.exception.ExceptionMain.checkSex(ExceptionMain.java:66)
//		at com.dawn.java.exception.ExceptionMain.main(ExceptionMain.java:8)
//	
//	
//	java.lang.IllegalStateException: 抛出新异常2，添加到异常链
//		at com.dawn.java.exception.ExceptionMain.checkSex2(ExceptionMain.java:55)
//		at com.dawn.java.exception.ExceptionMain.main(ExceptionMain.java:23)
//	Caused by: com.dawn.java.exception.SexException: unknown sex: 2
//		at com.dawn.java.exception.ExceptionMain.checkSex(ExceptionMain.java:66)
//		at com.dawn.java.exception.ExceptionMain.checkSex2(ExceptionMain.java:53)
//		... 1 more
//	
//	
//	java.lang.Exception: 抛出新异常3，添加到异常链                                                                             // 本轮调用最后一次捕获的异常信息
//		at com.dawn.java.exception.ExceptionMain.checkSex3(ExceptionMain.java:47)      // 本轮调用最后一次捕获的异常的位置信息
//		at com.dawn.java.exception.ExceptionMain.main(ExceptionMain.java:37)           // 本轮调用最后一次捕获的异常的调用栈信息，这里只有一条
//	Caused by: java.lang.IllegalStateException: 抛出新异常2，添加到异常链                                    // 中间的异常信息、位置、调用栈
//		at com.dawn.java.exception.ExceptionMain.checkSex2(ExceptionMain.java:55)
//		at com.dawn.java.exception.ExceptionMain.checkSex3(ExceptionMain.java:45)
//		... 1 more
//	Caused by: com.dawn.java.exception.SexException: unknown sex: 2                      // 起始异常信息、位置、调用栈
//		at com.dawn.java.exception.ExceptionMain.checkSex(ExceptionMain.java:66)
//		at com.dawn.java.exception.ExceptionMain.checkSex2(ExceptionMain.java:53)
//		... 2 more
}
