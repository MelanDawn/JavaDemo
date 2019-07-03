package com.dawn.design.pattern.singleton;

import com.dawn.java.util.Print;

public class SingletonMain {

	public static void main(String[] args) {
		/*
		 * 1、饿汉式（不可防止反射、序列化，存在变种）；
		 * 2、懒汉式（不可防止反射、序列化，存在变种）；
		 * 3、静态内部类（不可防止反射、序列化）；
		 * 4、枚举（最佳实践，可防止反射、序列化）。
		 */
		Print.println(SingletonLazy.getInstance().toString());
		Print.println(SingletonImmediately.getInstance().toString());
		Print.println(SingletonByInnerClass.getInstance().toString());
		Print.println(SingletonBySdk.getInstance().toString());
		Print.println(SingletonByEnum.INSTANCE.getLocalName());
	}
}
