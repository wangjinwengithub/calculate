package com.sort;

import com.alibaba.fastjson.JSON;

/**
 * 插入排序
 * @author 王劲文
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		Integer[] arr={63,1,2,5,9,5,25,6,4,2,6,4,2,8,6,4,2,5};
		System.out.println("排序前："+JSON.toJSONString(arr));
		int totalCicle=0;
		int exchange=0;
		for(int i=1;i<arr.length;i++){
			for(int j=i-1;j>=0;j--){
				totalCicle++;
				if(arr[j+1]<arr[j]){
					exchange++;
					int middle=arr[j+1];
					arr[j+1]=arr[j];
					arr[j	]=middle;
				}else{
					break;
				}
			}
			System.out.println("第"+i+"次："+JSON.toJSONString(arr));
		}
		System.out.println("排序后："+JSON.toJSONString(arr));
		System.out.println(totalCicle+"次循环");
		System.out.println(exchange+"次交换");
	}
}
