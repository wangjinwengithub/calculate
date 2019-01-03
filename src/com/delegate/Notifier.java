package com.delegate;

/**
 * 
 * @author 王劲文
 * 事件委托  具体监听类
 */
public class Notifier extends AbstractNotifier{

	@Override
	public void addlister(Object object, String methodName, Object... arg) {
		System.out.println("有人给前台买好吃的，叫他帮忙看着点老板！");
		hander.addEvent(object, methodName, arg);
	}

	@Override
	public void notifyX() {
		try {
			System.out.println("前台发现老板回来了，通知所有给他买好吃的人！");
			hander.notifyX();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
