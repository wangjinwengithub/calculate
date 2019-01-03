package com.delegate;

import java.util.Date;

/**
 * 
 * @author 王劲文
 * 事件委托  被通知者
 */
public class Ge {

	public Ge() {
		super();
		System.out.println("上班时间正在把妹，开始时间"+new Date());
	}
	
	public void stopPickUp(Date date){
		System.out.println("老板已回来，停止把妹，通知时间"+date);
	}

	
}
