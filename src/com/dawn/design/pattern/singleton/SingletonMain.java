package com.dawn.design.pattern.singleton;

import com.dawn.utils.Log;

public class SingletonMain {

	private static final String TAG = "SingletonMain";

	public static void main(String[] args) {
		/*
		 * 1、饿汉式（不可防止反射、序列化，存在变种）；
		 * 2、懒汉式（不可防止反射、序列化，存在变种）；
		 * 3、静态内部类（不可防止反射、序列化）；
		 * 4、枚举（最佳实践，可防止反射、序列化）。
		 */
		Log.d(TAG, SingletonLazy.getInstance().toString());
		Log.d(TAG, SingletonImmediately.getInstance().toString());
		Log.d(TAG, SingletonByInnerClass.getInstance().toString());
		Log.d(TAG, SingletonBySdk.getInstance().toString());
		Log.d(TAG, SingletonByEnum.INSTANCE.getLocalName());
	}
}
