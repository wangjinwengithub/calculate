package com.decoratorpattern;

/**
 * 装饰者模式测试
 * GranderFather类为被装饰类
 * Father类为装饰者类
 * Children*类为扩展类
 * Interface为接口
 * @author 王劲文
 *
 */
public class Test {
	
	public static void main(String[] args) {
		GranderFather gf=new GranderFather();
		Children1 c1=new Children1();
		Children2 c2=new Children2();
		Children3 c3=new Children3();
		c1.setFather(gf);
		c2.setFather(c1);
		c3.setFather(c2);
		c3.show();
	}

}
