package com.calculate;

import com.exception.DivisionException;

public class CalculateContext {

	private Interface inter;
	
	public CalculateContext(String opertion,double a,double b) throws DivisionException{
		switch (opertion) {
		case "+":
			inter=new AddCalculate(a, b);
			break;
		case "/":
			inter=new DivisionCalculate(a, b);
			break;
		case "-":
			inter=new SubtractionCalculate(a, b);

		default:
			break;
		}
		
	}

	public Interface getInter() {
		return inter;
	}

	public void setInter(Interface inter) {
		this.inter = inter;
	}
	
	public double getResult(){
	return	inter.getResult();
	}
	
	public String toString(){
		return inter.toString();
	}
	

}
