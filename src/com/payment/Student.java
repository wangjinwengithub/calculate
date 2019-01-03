package com.payment;

public class Student extends Man{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setSuperName(String name) {
		super.name=name;
	}
	
	public String getSuperName(){
		return super.name;
	}
	
	
	
	@Override
	public String toString() {
		return "老子："+super.name+"||儿子:"+this.name;
	}

	public static void main(String[] args) {
		Student student=new Student();
		student.setName("张三");
		student.setSuperName("张三爹");
		System.out.println(student.toString());
		System.out.println(student.getSuperName());
	}
}
