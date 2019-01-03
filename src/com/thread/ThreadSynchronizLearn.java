package com.thread;

public class ThreadSynchronizLearn {

	static Print print=new Print();
	public static void main(String[] args) {
		
		Thread thread1=new Thread(new Runnable() {
			public void run() {
				while (true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					print.print();
				}
			}
		});
		
		Thread thread2=new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					print.print1();
				}
			}
		});
		
		thread1.start();
		thread2.start();
	}
}

class Print{
	public synchronized void print(){
		String cir="菊花残，满地伤，你的笑容已泛黄！";
		for(int i=0;i<cir.length();i++){
			System.out.print(cir.substring(i,i+1));
		}
		System.out.println();
	}
	
	public synchronized void print1(){
		String cir="trouble is friends!";
		for(int i=0;i<cir.length();i++){
			System.out.print(cir.substring(i,i+1));
		}
		System.out.println();
	}
}
