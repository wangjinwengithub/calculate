package com;

/**
 * 二分查找
 * @author 王劲文
 *
 */
public class PartOfQuery {
	
	private static int count=0;
	private static int invokeNumber=0;
	
	public static void main(String[] args) {
		// 结束版本
		int endVersion=100;
		// 开始版本
		int beginVersion=0;
		
		int result=getMiddleVersion(beginVersion,endVersion);
		if(result==-1) System.err.println("查找结束，未找到有bug的版本");
		else System.err.println("查找结束，开始有bug的版本为："+result);
		System.err.println("isBugVersion调用次数为："+invokeNumber);
		
		
	}
	
	//判断当前版本是否有bug
	public static boolean isBugVersion(int version){
		invokeNumber++;
		System.out.println("第"+invokeNumber+"次调用isBugVersion，调用参数："+version);
		int bugStartVersion=88;//假设当前版本存在bug
		return version>=bugStartVersion;
	}
	
	//获取中间版本数目
	public static int getMiddleVersion(int beginVersion,int endVersion){
		count++;
		int middle=(endVersion - beginVersion)/2 + beginVersion;
		System.out.println("第"+count+"次递归调用，beginVersion："+beginVersion+"==>endVersion:"+endVersion+"==>middle:"+middle);
		if(isBugVersion(middle)){
			if(isBugVersion(middle-1)){
				endVersion=middle;
				if(endVersion-beginVersion==1) return beginVersion;
				middle=getMiddleVersion(beginVersion,endVersion);
			}else{
				System.out.println("找到bug版本，bug开始版本号："+middle);
				return middle;
			}
		}else{
			if(isBugVersion(middle+1)){
				middle++;
				System.out.println("找到bug版本，bug开始版本号："+(middle));
				return middle;
			}else{
				beginVersion=middle;
				if(endVersion-beginVersion==1) return -1;
				middle=getMiddleVersion(beginVersion,endVersion);
			}
			
		}
		return middle;
	}
	
	
	
	
}


