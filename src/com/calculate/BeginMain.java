package com.calculate;

import com.exception.DivisionException;

public class BeginMain {
	
	public static void main(String[] args) {
		/*Interface base;
		try {
			base = CalculateFactory.getBean("-", 1, -5);
			System.out.println(base.toString());
		} catch (DivisionException e) {
			System.out.println(e.getMessage());
		}*/
		
		try {
			CalculateContext context=new CalculateContext("-", 1, -6);
			System.out.println(context.getResult());
		} catch (DivisionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
