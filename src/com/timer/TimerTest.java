package com.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * java中的定时任务
 * @author 王劲文
 *
 */
public class TimerTest {

	public static void main(String[] args) {

		Timer t=new Timer();
		t.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("bingbom!");
				
			}
			
		}, 500,3000);
	}
	
	/**
	 * 读写锁
	 */
	private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
	
	public void write(){
		lock.writeLock().lock();
		lock.writeLock().unlock();
	}
	
	public void read(){
		lock.readLock().lock();
		lock.readLock().unlock();
	}

}
