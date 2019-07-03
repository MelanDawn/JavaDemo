package com.dawn.design.pattern.singleton;

public class SingletonBySdk {

	private static Singleton<SingletonBySdk> singleton;

	private SingletonBySdk() {

	}

	public static SingletonBySdk getInstance() {
		return singleton.get();
	}

	static {
		singleton = new Singleton<SingletonBySdk>() {
			@Override
			protected SingletonBySdk create() {
				return new SingletonBySdk();
			}
		};
	}

	private static abstract class Singleton<T> {
		private T mInstance;

		protected abstract T create();

		public final T get() {
			synchronized (Singleton.this) {
				if (mInstance == null) {
					mInstance = create();
				}
				return mInstance;
			}
		}
	}
}
