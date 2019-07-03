package com.dawn.design.pattern.singleton;

public enum SingletonByEnum {

	INSTANCE;

	private String localName = "SingletonByEnum";

	public String getLocalName() {
		return localName;
	}
}
