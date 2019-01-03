package com.lamada;

import org.junit.Test;

public class BaseLamada {

	public static void main(String[] args) {
		/****无参方法*****/
		Interface intf;
		intf=() -> 100;
		int a=intf.getInt();
		System.out.println(a);
		intf=() -> 200;
		System.out.println(intf.getInt());
		
		/****有参方法*****/
		Interface1 intf1 =(n) -> n/100;
		System.out.println(intf1.getValue(10));
		intf1=(n) -> {
			System.out.println("lamada块");
			int result=1;
			for(int i=1;i<=n;i++){
				System.out.println(result+"*"+i);
				result=result*i;
			}
			return result;
		};
		System.out.println(intf1.getValue(10));
		
		Interface2 intf2=(n,c) ->n/c;
		System.out.println(intf2.getInt(100, 10));
	}
	
	@Test
	public void testT(){
		Interface3T<String> int3T=() ->"滚滚滚！";
		System.out.println(int3T.getSomThing());
		int3T=()->{
			return "走走走！";
		};
		System.out.println(int3T.getSomThing());
	}
	
	@Test
	public void testT1(){
		int cc=10;
		Interface4T<Integer> int4T = (n) -> n; 
		System.out.println(int4T.getSomeThing(100));
		Interface4T<String> ints4T = (n) -> n;
		System.out.println(ints4T.getSomeThing("死老丁"));
		ints4T = (n) -> {
			/**
			 * 注意：这里不能改变cc的值，因为这里cc当做final类型来开待，
			 * 正是如此，才可以在lamada表达式里面引用之
			 */
			int bb=cc+125;
			System.out.println(bb);
			n=n+"怕过谁？";
			return n;
		};
		System.out.println(ints4T.getSomeThing("死老丁"));
	}
	public static void invokeTest(Interface4T<String> ints4T,String remark){
		System.out.println(ints4T.getSomeThing(remark));
	}
	
	@Test
	public void testMethod(){
		invokeTest((n) -> n,"给我滚！");
	}
	
}
