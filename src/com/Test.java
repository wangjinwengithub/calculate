package com;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	@SuppressWarnings("unchecked")
	public <T>T getObj(String newAttr,Class<?> T){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("a", 1);
		map.put("b", false);
		map.put("c", "string");
		T result=(T) map.get(newAttr);
		return result;
	}
	
	
	

	public static void main(String[] args) {
		String a=null;
		try{
			a.equals("");
		}catch(Exception e){
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}
}
