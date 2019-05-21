package com.dawn.java.serializable;

import java.io.Serializable;

public class SerializablePerson implements Serializable {

	private static final long serialVersionUID = 10086L;

	private int age = 1;

	private String name = "test";

	private transient String id = "111122223333444455";

	public static String father = "张二";

	public final String mother = "王五";

	public SerializablePerson() {

	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(" [").append(" name=").append(name).append(", age=").append(age)
				.append(", id=").append(id).append(", father=").append(father).append(", mother=").append(mother)
				.append(" ]");
		return sb.toString();
	}
}
