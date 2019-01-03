package com.delegate;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 王劲文
 * 事件委托  事件处理类
 */
public class EventHandler {
	
	private List<Event> event;

	public EventHandler() {
		super();
		this.event=new ArrayList<Event>();
	}
	
	public void addEvent(Object object,String methodName,Object...arg){
		event.add(new Event(object, methodName, arg));
	}
	
	public void notifyX() throws Exception{
		for(Event e:event){
			e.invoke();
		}
	}
	

}
