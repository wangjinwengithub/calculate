package com.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;


/**
 * ArrayList排序
 * @author Administrator
 *
 */
public class ArrayListSort {
	
	/**
	 * 字符串的默认排序
	 */
	@Test
	public void JDKSort(){
		List<String> list=new ArrayList<String>();
		list.add("ben");
		list.add("john");
		list.add("kun");
		list.add("huan");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		List<Integer> listint=new ArrayList<Integer>();
		listint.add(9);
		listint.add(5);
		listint.add(2);
		listint.add(7);
		System.out.println(listint);
		Collections.sort(listint);
		System.out.println(listint);
		}
	
	/**
	 * 对象排序
	 */
	@Test
	public void sortObject(){
		List<TestObj> list=new ArrayList<TestObj>();
		list.add(new TestObj("laoge",10));
		list.add(new TestObj("laoding",21));
		list.add(new TestObj("yesheng",17));
		list.add(new TestObj("laowang",15));
		System.out.println("排序前："+list);
		Collections.sort(list);
		System.out.println("排序后："+list);
		Collections.sort(list, list.get(0));
		System.out.println("排序后："+list);
		//oldCompare o=new oldCompare();
		//Collections.sort(list,o);
		//System.out.println("按年龄排序："+list);
		//oldCompareDesc odesc=new oldCompareDesc();
		//Collections.sort(list,odesc);
		//System.out.println("按年龄排倒序："+list);
	}

	@Test
	public void testHashSet(){
		Set<TestObj> set=new HashSet<TestObj>();
		set.add(new TestObj("laoge",10));
		set.add(new TestObj("laoding",21));
		set.add(new TestObj("yesheng",17));
		set.add(new TestObj("yesheng",17));
		set.add(new TestObj("laowang",15));
		System.out.println(set);
	}
	
	@Test
	public void testTreeSet(){
		oldCompareDesc odesc=new oldCompareDesc();
		Set<TestObj> set=new TreeSet<ArrayListSort.TestObj>(odesc);
		set.add(new TestObj("laoge",10));
		set.add(new TestObj("laoding",21));
		set.add(new TestObj("yesheng",17));
		set.add(new TestObj("yesheng",17));
		set.add(new TestObj("laowang",15));
		System.out.println(set);
	}
	
	class TestObj implements Comparable<TestObj>,Comparator<TestObj>{
		String name;
		int old;
		
		TestObj(String name,int old){
			this.name=name;
			this.old=old;
		}
		TestObj(){
			
		}
		
		@Override
		public int hashCode() {
			return this.name.hashCode()+this.old;
		}
		@Override
		public boolean equals(Object obj) {
			TestObj tObj=(TestObj) obj;
			return this.name.equals(tObj.name)&&this.old==tObj.old;
		}
		public String toString(){
			return "name:"+name+",old:"+old;
		}

		@Override
		public int compareTo(TestObj arg0) {
			return name.compareTo(arg0.name);
		}

		@Override
		public int compare(TestObj o1, TestObj o2) {
			return o1.old-o2.old;
		}
	}
	
	class oldCompare implements Comparator<TestObj>{
		@Override
		public int compare(TestObj o1, TestObj o2) {
			return o1.old-o2.old;
		}
	}
	
	class oldCompareDesc implements Comparator<TestObj>{
		@Override
		public int compare(TestObj o1, TestObj o2) {
			return o2.old-o1.old;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str;
		while(true){
			str = sc.next();
			str = str.replace("吗", "");
			str = str.replace("?", "!");
			str = str.replace("? ", "!");
			System.out.println(str);
		}
	}
}
