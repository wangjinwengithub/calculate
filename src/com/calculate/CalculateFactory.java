package com.calculate;

import com.exception.DivisionException;

public class CalculateFactory {
	
	public static Interface inter;
	
	public static Interface getBean(String operation,double firstNumber,double twoNumber) throws DivisionException{
		switch (operation) {
		case "+":
			inter=new AddCalculate(firstNumber, twoNumber);
			break;
			
		case "-":
			inter=new SubtractionCalculate(firstNumber, twoNumber);
			break;
		
		case "/":
			inter=new DivisionCalculate(firstNumber, twoNumber);
			break;

		default:
			break;
		}
		return inter;
	}

}
