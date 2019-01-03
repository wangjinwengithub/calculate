package com.MD5;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class Test {

	public static void main(String[] args) {
		File file=new File("F:/新建文本文档.txt");
		String test=MD5Util.getMD5(file);
		File file1=new File("C:/Users/Administrator/Desktop/工作日常/爱尚的DTO们.txt");
		String test1=MD5Util.getMD5(file1);
		System.out.println(test);
		System.out.println(test1);
		//c8c4241fe6131908a8efc6bb1d5f2500
		//49c61eac3e4867df09e95e485cae3976
		
//		Map<String,Integer> map=new HashMap<String, Integer>();
//		map.put("1", 1);
//		map.put("2", 2);
//		map.put("3", 3);
//		System.out.println(JSON.toJSONString(map));
//		map.remove("1");
//		System.out.println(JSON.toJSONString(map));
		
		
		
	}
}
