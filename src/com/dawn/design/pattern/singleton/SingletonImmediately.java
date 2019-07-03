package com.dawn.design.pattern.singleton;

public class SingletonImmediately {

	private static final SingletonImmediately sInstance = new SingletonImmediately();

	private SingletonImmediately() {

	}

	public static SingletonImmediately getInstance() {
		return sInstance;
	}

}
