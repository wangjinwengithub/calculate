package com.thread;

/**
 * new 线程的两种方式
 * @author 王劲文
 *
 */
public class ThreadLearn {
	public static int i=0;
	public static void main(String[] args) {
		
		Thread t=new Thread(){
			public void run(){
				int b=0;
				while(true){
					b++;
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					i=i+1;
					
					System.out.println("线程："+Thread.currentThread().getName()+" 第"+b+"次循环。i="+i);
					if(b==50){
						break;
					}
				}
				
			}
			
		};
		
		Thread t1=new Thread(new Runnable() {
			
			public void run() {
				int b=0;
				while(true){
					b++;
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					i=i+1;
					
					System.out.println("线程："+Thread.currentThread().getName()+" 第"+b+"次循环。i="+i);
					if(b==50){
						break;
					}
				}
			}
		});
		
		t.start();
		t1.start();	
		System.out.println(i);
		
	}
	
	class myRunable implements Runnable{
		public void run() {
			for(int i=0; i<50; i++){
				System.out.println("当前线程："+Thread.currentThread().getName());
			}
		}
		public void print(){
			String cir="菊花残，满地伤，你的笑容已泛黄！";
			for(int i=0;i<cir.length()-1;i++){
				System.out.println(cir.substring(i,i+1));
			}
		}
		
		public void print1(){
			String cir="trouble is friends!";
			for(int i=0;i<cir.length()-1;i++){
				System.out.println(cir.substring(i,i+1));
			}
		}
	}
}
