package com.dawn.design.pattern.singleton;

public class SingletonByInnerClass {

	private SingletonByInnerClass() {

	}

	public static SingletonByInnerClass getInstance() {
		return SingletonInner.INSTANCE;
	}

	static class SingletonInner {
		private static final SingletonByInnerClass INSTANCE = new SingletonByInnerClass();
	}
}
