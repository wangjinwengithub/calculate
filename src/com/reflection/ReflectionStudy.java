package com.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ReflectionStudy {

	/**class类型装换：将一个类（Student）的class类型强行装换为指定类（Man）的class类型的一个子类，更精确的类型装换，一般用来防止编译警告**/
	@Test
	public void asSubclass(){
		Student student=new Student();
		Class<? extends Man> man=student.getClass().asSubclass(Man.class);
		System.out.println(man.getCanonicalName()+"----asSubclass");
	}
	
	/**将一个对象强制转换成此 Class 对象所表示的类或接口。**/
	@Test
	public void cast(){
		Student obj=new Student();
		Man s=Man.class.cast(obj);
		System.out.println(s.getClass().getCanonicalName()+"----cast");
	}
	
	@Test
	public void forName(){
		try {
			Student s=(Student) Class.forName("com.reflection.Student").newInstance();
			Student s1=(Student) Class.forName("com.reflection.Student", true, this.getClass().getClassLoader()).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAnnotations() {
		Annotation[] a=Student.class.getDeclaredAnnotations();
		System.out.println(a.length);
		for(Annotation a1 : a){
			System.out.println(a1.annotationType());
		}
		System.out.println();
	}
	
	@Test
	public void getDeclaredFields() throws Exception {
		//获取该类所有属性
		Field[] fild=Student.class.getDeclaredFields();
		
		//获取该类以及父类所有公共属性
		Field[] fild1=Student.class.getFields();
		for(int i=0;i<fild1.length;i++){
			System.out.println("包括父类：");
			System.out.println("属性类型："+fild1[i].getGenericType());
			System.out.println("属性名称："+fild1[i].getName());
		}
		//获取其父类的所有属性
		Field[] fild2 = Student.class.getSuperclass().getDeclaredFields();
		int index=fild.length+fild2.length;
		Field[] allFild=new Field[index];
		System.out.println("父类所有属性：");
		for(int i=0;i<fild2.length;i++){
			System.out.println("属性类型："+fild2[i].getGenericType());
			System.out.println("属性名称："+fild2[i].getName());
			allFild[i]=fild2[i];
		}
		int newFild=fild2.length;
		for(int i=0;i<fild.length;i++){
			System.out.println("单类属性类型："+fild[i].getGenericType());
			System.out.println("单类属性名称："+fild[i].getName());
			allFild[newFild++]=fild[i];
		}
		System.out.println("所有属性：");
		for(int i=0;i<index;i++){
			System.out.println("属性类型："+allFild[i].getGenericType());
			System.out.println("属性名称："+allFild[i].getName());
		}
		
		System.out.println("准备执行方法！");
		System.out.println("所有set方法");
		Class<Student> c=Student.class;
		Student student=new Student();
		for(int i=0;i<index;i++){
			String methodName="set"+allFild[i].getName().substring(0,1).toUpperCase()+allFild[i].getName().substring(1);
			System.out.println("执行方法："+methodName);
			Method me=c.getMethod(methodName, String.class);
			me.invoke(student, "hello,world"+i);
			
			String getMethodName="get"+allFild[i].getName().substring(0,1).toUpperCase()+allFild[i].getName().substring(1);
			System.out.println("执行方法："+getMethodName);
			Method gme=c.getMethod(getMethodName, null);
			System.out.println(gme.invoke(student, null));
			
		}
		
		//执行多个参数方法
		Method mm=c.getMethod("setAllValue", String.class,String.class,String.class);
		mm.invoke(new Student(),"aaaa","ffffff0","ccccccc" );
		
		//数组参数
		String[] str={"ssss"};
		Method cc=c.getMethod("setAllValue", String[].class);
		cc.invoke(new Student(), new Object[]{str});
		
	}
	@Test	
	public void test(){
		Student s=new Student();
		Map<String, String> map=new HashMap<String, String>();
		System.out.println(map.getClass().isSynthetic());
		System.out.println(s.getClass().getSimpleName());
		System.out.println(map.getClass().getSimpleName());
		
		
	}
	
	@Test
	public void testMethod(){
		Method[] m=Student.class.getDeclaredMethods();
		for(int i=0;i<m.length;i++){
			System.out.println("方法名："+m[i].getName());
			System.out.println("*******************************************");
			Annotation[] a=m[i].getDeclaredAnnotations();
			for(int s=0;s<a.length;s++){
				System.out.println(a[s].toString());
			}
			System.out.println("*******************************************");
		}
	}
	
	@Test
	public void testType(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("qwe", "123");
		cicleObject(map);
		JSONObject obj=new JSONObject();
		obj.put("qqq", false);
		cicleObject(obj);
	} 
	
	public static void cicleObject(Object o){
		String oType=o.getClass().getTypeName();
		System.out.println(oType);
		if("java.util.HashMap".equals(oType)){
			Map<?, ?> m=(Map<?, ?>) o;
			for(Map.Entry<?, ?> entry:m.entrySet()){
			        String key = (String) entry.getKey();
			        String value = (String) entry.getValue();
			        System.out.println(key + "=" + value);
			}
			
		}else if("com.alibaba.fastjson.JSONObject".equals(oType)){
			JSONObject obj=(JSONObject) o;
			for (Map.Entry<String, Object> entry : obj.entrySet()) {
				System.out.println(entry.getKey() + "=" + entry.getValue());
		    }
		}else{
		Field[] field=o.getClass().getFields();
		for(int i=0;i<field.length;i++){
			System.out.println(field[i].getName());
		}
		}
	} 


}
