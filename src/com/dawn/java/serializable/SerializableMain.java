package com.dawn.java.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.dawn.java.util.PathUtil;

/****************** Serializable 自动序列化执行过程日志分析 ***********************/
// 注释掉字段的get、set方法执行结果如下，可知：字段赋值应该是用反射机制实现
// com.dawn.java.serializable.Person@7852e922 [ name=test, age=1, id=111122223333444455, father=张二 ]
// com.dawn.java.serializable.Person@6d311334 [ name=test, age=1, id=null, father=李一 ]

// 正常get、set方法执行结果如下，可知：
// 1、Serializable接口情况下，transient修饰的字段（id）不会被序列化；
// 2、静态字段（father）不会被序列化
// com.dawn.java.serializable.Person@7852e922 [ name=张三, age=30, id=421127118902171234, father=张二 ]
// com.dawn.java.serializable.Person@6d311334 [ name=张三, age=30, id=null, father=李一 ]

/*************** Serializable Externalizable 序列化执行过程日志分析 *****************/
//com.dawn.java.serializable.SerializablePerson@7852e922 [ name=张三, age=30, id=421127118902171234, father=张二, mother=王五 ]
//com.dawn.java.serializable.SerializablePerson@682a0b20 [ name=张三, age=30, id=null, father=李一, mother=王五 ]
//
//com.dawn.java.serializable.ExternalizablePerson@3d075dc0 [ name=张三, age=30, id=421127118902171234, father=张二, mother=王五 ]
//com.dawn.java.serializable.ExternalizablePerson@3b9a45b3 [ name=test, age=30, id=421127118902171234, father=张二, mother=王五 ]

public class SerializableMain {

	private static final String SERIALIZABLE_FILE_PATH = PathUtil.getAbsolutePath(SerializableMain.class)
			+ File.separator + "SerializablePerson.txt";
	private static final String EXTERNALIZABLE_FILE_PATH = PathUtil.getAbsolutePath(SerializableMain.class)
			+ File.separator + "ExternalizablePerson.txt";

	public static void main(String[] args) throws IOException {

		SerializablePerson person = new SerializablePerson();
		person.setAge(30);
		person.setName("张三");
		person.setId("421127118902171234");
		SerializablePerson.father = "张二";
		System.out.println(person.toString());

		serialize(person);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		SerializablePerson.father = "李一";
		SerializablePerson deserializePerson = deserialize();
		if (deserializePerson != null) {
			System.out.println(deserializePerson.toString());
		} else {
			System.out.println("serialize failed!");
		}

		System.out.println();
		/* Externalizable 执行过程 */
		ExternalizablePerson externalizablePerson = new ExternalizablePerson();
		externalizablePerson.setAge(30);
		externalizablePerson.setName("张三");
		externalizablePerson.setId("421127118902171234");
		ExternalizablePerson.father = "张二";
		System.out.println(externalizablePerson.toString());

		try {
			externalizable(externalizablePerson);

			Thread.sleep(1000);

			ExternalizablePerson.father = "李一";
			ExternalizablePerson dexternalizablePerson = dexternalizable();
			if (dexternalizablePerson != null) {
				System.out.println(dexternalizablePerson.toString());
			} else {
				System.out.println("dexternalizable failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void serialize(SerializablePerson person) {

		ObjectOutputStream oos = null;
		try {
			File file = new File(SERIALIZABLE_FILE_PATH);
			if (!file.exists()) {
				file.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(person);
			oos.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

	public static SerializablePerson deserialize() {
		ObjectInputStream ois = null;
		SerializablePerson person = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(SERIALIZABLE_FILE_PATH));
			person = (SerializablePerson) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}

	public static void externalizable(ExternalizablePerson person) throws Exception {
		File file = new File(EXTERNALIZABLE_FILE_PATH);
		if (!file.exists()) {
			file.createNewFile();
		}
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(person);
		out.close();

	}

	public static ExternalizablePerson dexternalizable() throws Exception {
		ExternalizablePerson person = null;
		ObjectInput in = new ObjectInputStream(new FileInputStream(EXTERNALIZABLE_FILE_PATH));
		person = (ExternalizablePerson) in.readObject();
		in.close();
		return person;
	}

}
