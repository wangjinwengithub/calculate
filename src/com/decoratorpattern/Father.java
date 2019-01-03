package com.decoratorpattern;

public class Father implements Interface{

	protected Interface father;
	
	public void show(){
		father.show();
		System.out.println("父类在努力！");
	}

	public void setFather(Interface father) {
		this.father = father;
	};
	
	
}
