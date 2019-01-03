package com.sort;

import com.alibaba.fastjson.JSON;

/**
 * 选择排序
 * 思想：从数组中找出最小/最大的一个数据，然后这个数据跟第一个数据交换，再从剩余数据中找到其最小的，然后这个数据跟第二个交换，依次类推
 * 算法复杂度：N*N ，找出最小数循环次数：(N-1)+(N-2)+.........+(N-N-2)+(N-N-1)=N*N/2,极端请款下交换次数为N，数组有序时交换次数为0
 * 不足:每次循环找到最小数，只对本次循环有用，对下一次查找无影响。无论数组顺序有多乱，是否有序，对于选择排序来说，算法复杂度都是一样的
 * @author WangJW
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		Integer[] arr={63,1,2,5,9,5,25,6,4,2,6,4,2,8,6,4,2,5};
		System.out.println("排序前数数组："+JSON.toJSONString(arr));
		int totalCicle=0;
		int exchange=0;
		int N=arr.length;
		for(int i=0;i<N;i++){
			int minIndex=i;
			//找出数组中最小数的下标
			for(int j=i+1;j<N;j++){
				totalCicle++;
				if(arr[minIndex]>arr[j]){
					minIndex=j;
				}
			}
			if(minIndex!=i){
				exchange++;
				int middle=arr[minIndex];
				arr[minIndex]=arr[i];
				arr[i]=middle;
			}
			System.out.println("第"+(i+1)+"次:"+JSON.toJSONString(arr));
		}
		
		System.out.println("排序后数数组："+JSON.toJSONString(arr));
		System.out.println(totalCicle+"次循环");
		System.out.println(exchange+"次交换");
	}
	
}
