package com.calculate;

public class AthTest {

	/**
	 * 
	* @Title: main 
	* @Description: 别运行，会死的
	* @return void    
	* @author WangJW
	* @date 2018年7月24日 下午7:12:01
	 */
	
	public static void main(String[] args) {
		
		long a,b,c,d=0;
		for(a=0;;a++){
			for(b=0;;b++){
				for(c=0;;c++){
					d++;
					System.out.println(d);
					if(((a*(a+c)*(a+b))+(b*(b+c)*(a+b))+(c*(a+c)*(c+b)))==4*(a+c)*(a+b)*(c+b)&&b+c!=0&&a+c!=0&&a+b!=0){
						System.out.println("a="+a);
						System.out.println("b="+b);
						System.out.println("c="+c);
						System.out.println("-------------------");
					}
					
					
				}
			}
		}
//		System.out.println("一共有:"+d);
	
	}
	
}
