package com.payment;

public class Fectory {
	
	private static Object obj;
	
	public static Object initObje(Object o,int n){
		
		switch (n) {
		case 0:
			obj=new Object();
			obj.toString();
			break;

		default:
			obj=new Object();
			obj.toString();
			break;
		}
		
		return obj;
	}
	
	
}
