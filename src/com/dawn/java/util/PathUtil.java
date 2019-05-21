package com.dawn.java.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PathUtil {
	// D:\programdata\JavaSpace\JavaDemo
	private static final String PROJECT_ROOT_PATH = System.getProperty("user.dir");
	// 源码目录名称
	private static final String SRC = "src";

	public static String getRootPath() {
		return PROJECT_ROOT_PATH;
	}

	public static String getAbsolutePath(Class<?> class1) {
		// com\dawn\java\\util（触发了 unicode，因此这里有\\表示转义）
		String classPackagePath = class1.getPackage().getName().replace(".", File.separator);
		return PROJECT_ROOT_PATH + File.separator + SRC + File.separator + classPackagePath;
	}

//	public static void main(String[] args) {
//		try {
//			getPath(PathUtil.class);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		String packAge = PathUtil.class.getPackage().getName();
//		System.err.println(packAge);
//		String path = packAge.replace(".", File.separator);
//		System.err.println(path);
//	}

	@SuppressWarnings("unused")
	private static void getPath(Class<?> class1) throws IOException {
		// 第一种：获取类加载的根路径 D:\git\daotie\daotie\target\classes
		File f = new File(class1.getResource("/").getPath());
		System.out.println(f);

		// 获取当前类的所在工程路径; 如果不加“/” 获取当前类的加载目录 D:\git\daotie\daotie\target\classes\my
		File f2 = new File(class1.getResource("").getPath());
		System.out.println(f2);

		// 第二种：获取项目路径 D:\git\daotie\daotie
		File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();
		System.out.println(courseFile);

		// 第三种： file:/D:/git/daotie/daotie/target/classes/
		URL xmlpath = class1.getClassLoader().getResource("");
		System.out.println(xmlpath);

		// 第四种： D:\git\daotie\daotie
		System.out.println(System.getProperty("user.dir"));
		/*
		 * 结果： C:\Documents and Settings\Administrator\workspace\projectName 获取当前工程路径
		 */

		// 第五种： 获取所有的类路径 包括jar包的路径
		System.out.println(System.getProperty("java.class.path"));
	}

}
