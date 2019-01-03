package com.thread.design.pattern.producer_customer;

import java.util.LinkedList;

/**
 * 数据队列
 * @author Administrator
 * @param <E>
 *
 */
public class DataQueue<E> {

	private final LinkedList<E> dataQueue=new LinkedList<E>();
	
	public synchronized void pull(E e) {
		dataQueue.addLast(e);
	}
	
	public synchronized E pool(){
		E e=dataQueue.getFirst();
		dataQueue.removeFirst();
		return e;
	}
	
	public int size(){
		return dataQueue.size();
	}
	
}
