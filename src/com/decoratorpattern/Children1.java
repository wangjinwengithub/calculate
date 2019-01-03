package com.decoratorpattern;

public class Children1 extends Father{

	@Override
	public void show() {
		super.show();
		System.out.println("第一个儿子！"+abc);
	}
	
	

}
