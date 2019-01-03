package com.exception;

public class DivisionException extends Exception{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "被除数不能为0";
	}

}
