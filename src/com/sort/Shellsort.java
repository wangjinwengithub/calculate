package com.sort;

import com.alibaba.fastjson.JSON;

/**
 * 希尔排序
 * @author 王劲文
 *
 */
public class Shellsort {
	
	public static void main(String[] args) {
		Integer[] arr={63,1,2,5,9,5,25,6,4,2,6,4,2,8,6,4,2,5};
		System.out.println("排序前："+JSON.toJSONString(arr));
		int totalCicle=0;
		int exchange=0;
		int h=1;
		int N=arr.length;
		int number=0;
		while(h<N/3){
			h=3*h+1;
		}
		while(h>=1){
			System.out.println("----------------h="+h+"--------------");
			for(int i=0;i<N;i++){
				for(int j=i;j>=h&&j>=0&&j-h>=0;j-=h){
					totalCicle++;
					if(arr[j]<arr[j-h]){
						exchange++;
						int middle=arr[j];
						arr[j]=arr[j-h];
						arr[j-h]=middle;
					}else{
						if(h==1){
							break;
						}
					}
					System.out.println(++number+"次："+JSON.toJSONString(arr));
				}
				
			}
			h=h/3;
		}
		System.out.println("排序后："+JSON.toJSONString(arr));
		System.out.println("循环比较次数："+totalCicle);
		System.out.println("交换次数："+exchange);
	}

}
