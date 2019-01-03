package com.thread.design.pattern.producer_customer;
/**
 * 生产者
 * @author Administrator
 * @param <E>
 *
 */
public class Producer implements Runnable{

	private DataQueue<String> DataQueue;
	
	
	public Producer(DataQueue<String> dataQueue) {
		super();
		DataQueue = dataQueue;
	}


	@Override
	public void run() {
			try{
				System.out.println(Thread.currentThread().getName()+"生产者开始生产");
				while(true){
					System.out.println("生产成功！"+DataQueue.size());
					DataQueue.pull("String");
					Thread.sleep(3000);
				}
			}catch(Exception e){
				
			}
				
	}

}
