package com.delegate;

/**
 * 
 * @author 王劲文
 * 事件委托  监听类抽象类
 */
public abstract class AbstractNotifier {

	EventHandler hander=new EventHandler();

	public EventHandler getHander() {
		return hander;
	}

	public void setHander(EventHandler hander) {
		this.hander = hander;
	}
	
	public abstract void addlister(Object object,String methodName,Object...arg);
	
	public abstract void notifyX();
}
