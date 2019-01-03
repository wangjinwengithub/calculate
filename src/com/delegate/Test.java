package com.delegate;

import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
		
		Notifier notifier=new Notifier();
		
		Ge ge=new Ge();
		Liu liu=new Liu();
		
		notifier.addlister(ge, "stopPickUp", new Date());
		Object[] o=new Object[2];
		o[0]=new Date();
		o[1]="我勒个去！";
		notifier.addlister(liu, "stopEat", o);
		try{   
		    //一点时间后   
		    Thread.sleep(2000);   
		}catch(Exception e){   
		    e.printStackTrace();   
		}   
		notifier.notifyX();
	}
	
}
