package com.reflection;


public class Student extends Man{
	@ATest(id=true,name="张三",editable=true,description="字段描述")
	private String classs="默认班级！";
	
	/**获取班级**/
	public String getClasss() {
		System.out.println("获取班级信息！");
		return classs;
	}

	/**设置班级**/
	public void setClasss(String classs) {
		System.out.println("设置班级信息！"+classs);
		this.classs = classs;
	}

	public Student(String classs) {
		super();
		this.classs = classs;
	}

	public Student() {
		super();
	}
	
	public void setAllValue(String age,String name,String classs){
		System.err.println("通吃所有的属性！");
	}
	
	/******来吧来吧，相约九八！********/
	public void setAllValue(String[] age){
		System.err.println("数组参数！");
	}

	
}
