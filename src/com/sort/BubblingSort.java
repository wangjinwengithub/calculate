package com.sort;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序
 * 思想：从第0个数开始，比较该数与其它数的大小，比较过程中，该数小于与之比较的数时，两个数交换位置后接着与后面的数比较，重复之前的操作，直至所有数都比较完为止
 * 算法复杂度：N*N ，比较次数(N-1)+(N-2)+.........+(N-N-2)+(N-N-1)=N*N/2，交换次数(N-1)+(N-2)+.........+(N-N-2)+(N-N-1)=N*N/2
 * 不足：数据交换次数较多，再极端情况下，交换次数为N*N/2,在数组有序的情况下交换次数为0。无论数组顺序有多乱，是否有序，都需要去一一比较，对于冒泡排序来说，算法复杂度都是一样的
 * @author WangJW
 *
 */
public class BubblingSort {

	public static void main(String[] args) {
		Integer[] arr={63,1,2,5,9,5,25,6,4,2,6,4,2,8,6,4,2,5};
		Integer[] arr2={63,1,2,5,9,5,25,6,4,2,6,4,2,8,6,4,2,5};
		System.out.println("排序前数数组："+JSON.toJSONString(arr));
		int totalCicle=0;
		int exchange=0;
		int N=arr.length;
		int N2=arr2.length;
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				totalCicle++;
				if(arr[i]>arr[j]){
					exchange++;
					int middle=arr[i];
					arr[i]=arr[j];
					arr[j]=middle;
				}
			}
			System.out.println("第"+(i+1)+"次排序："+JSON.toJSONString(arr));
		}
		System.out.println("排序后数组："+JSON.toJSONString(arr));
		System.out.println(totalCicle+"次循环");
		System.out.println(exchange+"次交换");
		System.out.println("------------------------------------");
		totalCicle=0;
		exchange=0;
		for(int i=0;i<N2;i++){
			for(int j=i+1;j<N2;j++){
				totalCicle++;
				if(arr2[j]>arr2[i]){
					int middle=arr2[i];
					arr2[i]=arr2[j];
					arr2[j]=middle;
					exchange++;
				}
			}
			System.out.println("第"+(i+1)+"次排序："+JSON.toJSONString(arr2));
		}
		
		System.out.println("排序后数组："+JSON.toJSONString(arr2));
		System.out.println(totalCicle+"次循环");
		System.out.println(exchange+"次交换");
	}
}
