package com.calculate;

public class AddCalculate extends Base{
	
	public AddCalculate(double firstNumber,double twoNumber){
		this.firstNumber=firstNumber;
		this.twoNumber=twoNumber;
		this.getResult();
	} 
	public double getResult() {
		result=firstNumber+twoNumber;
		return result;
	}
	@Override
	public String toString() {
		super.toString();
		return firstNumber+"+"+twoNumber+"="+result;
	}

}
