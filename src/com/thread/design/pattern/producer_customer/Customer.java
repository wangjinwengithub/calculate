package com.thread.design.pattern.producer_customer;
/**
 * 消费者
 * @author Administrator
 * @param <E>
 *
 */
public class Customer implements Runnable{
	
	private DataQueue<String> DataQueue;

	public Customer(DataQueue<String> dataQueue) {
		super();
		DataQueue = dataQueue;
	}


	@Override
	public void run() {
		try{
				System.out.println(Thread.currentThread().getName()+"消费者启动");
				while(true){
					while (DataQueue.size()>0){
						String s=DataQueue.pool();
						System.out.println(Thread.currentThread().getName()+"消费者消费："+s+"剩余："+DataQueue.size());
						Thread.sleep(3000);
					}
					System.out.println(Thread.currentThread().getName()+"未消费");
					Thread.sleep(3000);
			}
		}catch(Exception e){
			
		}
	}

}
