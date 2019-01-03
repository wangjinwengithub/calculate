package com.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;

/**
 * map的简单实现
 * @author 王劲文
 *
 */
public class MyMap<K,V> implements Iterable<K>{

	@Override
	public String toString() {
		StringBuilder result=new StringBuilder();
		for(int i=0;i<pairs.length;i++){
			result.append(pairs[i][0].toString());
			result.append(" : ");
			result.append(pairs[i][1]);
			if(i<index-1)
				result.append("\n");
		}
		return result.toString();
	}

	private Object[][] pairs;
	private int index;
	public MyMap(int length) {
		super();
		pairs=new Object[length][2];
	}
	
	public void put(K key,V value){
		if(index >= pairs.length)
			throw new ArrayIndexOutOfBoundsException();
		pairs[index++]=new Object[]{key,value};
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key){
		for(int i=0;i<index;i++)
			if(key.equals(pairs[i][0]))
				return (V) pairs[i][1];
		return null;
	}
	
	public static void main(String[] args) {
		MyMap<String, String> map=new MyMap<String, String>(3);
		String a="name";
		int h = a.hashCode();
		System.out.println((123456987*100)&10);
		Map<String,String> hashMap=new HashMap<String, String>();
		for(Entry<String, String> entry:hashMap.entrySet()){
			System.out.println(entry.getKey());
		}
		Map<String,String> linkHashMap=new LinkedHashMap<String, String>();
		linkHashMap.put("", "");
		
		String[] str=new String[10];
		str[0]="as";
		System.out.println(JSON.toJSONString(str));
	}

	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
