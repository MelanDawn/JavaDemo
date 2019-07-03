package com.dawn.design.pattern.singleton;

public class SingletonLazy {

	private static volatile SingletonLazy sInstance = null;

	private SingletonLazy() {

	}

	public static SingletonLazy getInstance() {
		if (sInstance == null) {
			synchronized (SingletonLazy.class) {
				if (sInstance == null) {
					sInstance = new SingletonLazy();
				}
			}
		}
		return sInstance;
	}

}
