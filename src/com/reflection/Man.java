package com.reflection;

/**
 * 
 * @author 王劲文
 * 这是一个人
 *
 */
public class Man {

	private String age="默认年龄";
	
	private String name="默认姓名";

	public String getAge() {
		System.out.println("获取年龄信息！");
		return age;
	}

	public void setAge(String age) {
		System.out.println("设置年龄信息！"+age);
		this.age = age;
	}

	public String getName() {
		System.out.println("获取姓名信息！");
		return name;
	}

	public void setName(String name) {
		System.out.println("设置姓名信息！"+name);
		this.name = name;
	}
	
	public static void main(String[] args) {
		char[] a={'a'};
		System.out.println(a[0]+100);
		System.out.println("a"+100);
		System.out.println('a'+100);
	}
	
	
	
}
