package com.calculate;

public class SubtractionCalculate extends Base{
	
	public SubtractionCalculate(double firstNumber,double twoNumber){
		this.firstNumber=firstNumber;
		this.twoNumber=twoNumber;
		this.getResult();
	} 
	
	public double getResult() {
		result=firstNumber-twoNumber;
		return result;
	}

	@Override
	public String toString() {
		super.toString();
		if(twoNumber<0){
			return firstNumber+"-("+twoNumber+")="+result;
		}
		return firstNumber+"-"+twoNumber+"="+result;
	}
	
}
