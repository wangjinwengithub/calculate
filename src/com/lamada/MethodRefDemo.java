package com.lamada;

public class MethodRefDemo {
	public static String invokeTest(Interface4T<String> ints4T,String remark){
		//System.out.println(ints4T.getSomeThing(remark));
		return ints4T.getSomeThing(remark);
	}

	public static void main(String[] args) {
		/*调用静态方法*/
		String a=invokeTest(MyStringOpt::invokeTestAdd,"来吧");
		System.out.println(a);
		/**调用非静态方法***/
		MyStringOpt1 opt1=new MyStringOpt1();
		String b=invokeTest(opt1::invokeTestAdd,"cc");
		System.out.println(b);
		b=invokeTest(opt1::aa,"aa");
		System.out.println(b);
		
		
	}
}
