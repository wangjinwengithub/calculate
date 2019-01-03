package com.calculate;

public class Base implements Interface{
	
	protected double firstNumber;
	
	protected double twoNumber;
	
	protected double result;

	public double getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(double firstNumber) {
		this.firstNumber = firstNumber;
	}

	public double getTwoNumber() {
		return twoNumber;
	}

	public void setTwoNumber(double twoNumber) {
		this.twoNumber = twoNumber;
	}
	
	
	public void setResult(double result) {
		this.result = result;
	}

	public double getResult(){
		return result;
	}
	
	@Override
	public String toString() {
		System.out.print("计算过程:");
		return null;
	}
	

}
