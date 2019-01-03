package com.thread.design.pattern.producer_customer;


public class Main {

	public static void main(String[] args) {
		DataQueue<String> queue=new DataQueue<String>();
		new Thread(new Customer(queue)).start();
		new Thread(new Customer(queue)).start();
		new Thread(new Customer(queue)).start();
		new Thread(new Customer(queue)).start();
		new Thread(new Producer(queue)).start();
		new Thread(new Producer(queue)).start();
		new Thread(new Producer(queue)).start();
		new Thread(new Producer(queue)).start();
	}
}
