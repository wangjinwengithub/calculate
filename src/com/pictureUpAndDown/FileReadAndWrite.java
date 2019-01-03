package com.pictureUpAndDown;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FileReadAndWrite {

	public static void main(String[] args) {
		 BufferedWriter out=null;
		 InputStreamReader reader=null;
		  try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			  String a="10018031705101";
			  String b="748000";
			  String d="2018072112";
			  /* 读入TXT文件 */  
	            String pathname = "D:\\ejb1_new.out"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
	            File filename = new File(pathname); // 要读取以上路径的input。txt文件  
	            reader = new InputStreamReader(  
	                    new FileInputStream(filename),"utf-8"); // 建立一个输入流对象reader 
	            File writename = new File("D:\\outejb1_new.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件  
 	            writename.createNewFile(); // 创建新文件  
 	            out = new BufferedWriter(new FileWriter(writename)); 
	            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
	            String line = "";  
	            line = br.readLine();  
	            int i=0;
	            int c=0;
	            while (line != null) {
	            	i++;
	                if(line.indexOf(a)>0&&line.indexOf(b)>0&&line.indexOf(d)>0){
		            	  /* 写入Txt文件 */ 
	                	System.out.println(line);
	                	c++;
		 	            out.write(line); // \r\n即为换行  
		 	            out.write("\r\n"); 
		 	           
		            }
	                if(i%500==0){
	                	System.out.println("已找了"+i+"行");
	                	System.out.println("找到了"+c+"行");
	                }
	                line = br.readLine(); // 一次读入一行数据  
	                if(i==1000000){
	                	break;
	                }
	            }  
	            System.out.println("---------------查找结束--------------");
	            System.out.println("共查找了"+i+"行");
	            System.out.println("找到了"+c+"行");
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally{
	        	 try {
					out.flush(); // 把缓存区内容压入文件  
					out.close(); // 最后记得关闭文件  
			 	    reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
	 	        
	        } 
	}
	
	public static void find(){
		 BufferedWriter out=null;
		 InputStreamReader reader=null;
		try{
			 String a="10017061400332";
			 String pathname = "D:\\ejb1_new.out"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
	            File filename = new File(pathname); // 要读取以上路径的input。txt文件  
	            reader = new InputStreamReader(  
	                    new FileInputStream(filename)); // 建立一个输入流对象reader 
	            File writename = new File("D:\\outejb1_new.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件  
	            writename.createNewFile(); // 创建新文件  
	            out = new BufferedWriter(new FileWriter(writename)); 
	            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
	            List<String> list=new ArrayList<String>(); 
	            String line = "";  
	            line = br.readLine();  
	            int i=0;
	            int c=0;
	            while (line != null) {  
	            	i++;
	                if(line.indexOf(a)>0){
	                	c++;
	                	int first=line.lastIndexOf(".")+1;
	                	int end=line.length()-1;
	                	list.add(line.substring(first,end));
		 	           
		            }
	                if(i%500==0){
	                	System.out.println("已找了"+i+"行");
	                	System.out.println("找到了"+c+"行");
	                }
	                line = br.readLine(); // 一次读入一行数据  
	                if(i==1000000){
	                	break;
	                }
	            } 
			 
		}catch(Exception e){
			
		}finally{
			
		}
		
		
	}
	
	@Test
	public  void test123(){
		String a="java.com";
		System.out.println(a.indexOf("."));
		System.out.println(a.substring(a.indexOf(".")+1,a.length()-1));
	}
	
	
}
