package com.calculate;

import com.exception.DivisionException;

public class DivisionCalculate extends Base{
	
	public DivisionCalculate(double firstNumber,double twoNumer) throws DivisionException{
		this.firstNumber=firstNumber;
		this.twoNumber=twoNumer;
		this.getResults();
	}

	public double getResults() throws DivisionException {
		if(twoNumber==0){
			throw new DivisionException();
		}else{
			result=firstNumber/twoNumber;
		}
		return result;
	}
	@Override
	public String toString() {
		super.toString();
		return firstNumber+"/"+twoNumber+"="+result;
	}

}
