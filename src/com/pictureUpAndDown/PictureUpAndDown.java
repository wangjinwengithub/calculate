package com.pictureUpAndDown;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PictureUpAndDown {
	
	/**
	 * 
	* @Title: getPictureStream 
	* @Description: TODO(获取图片输入流)
	* @return  
	* @return InputStream    
	 * @throws IOException 
	 * @throws 
	* @author 王劲文
	* @date 2017年11月30日 下午5:09:31
	 */
	public static InputStream getPictureStream() throws IOException{
		 FileInputStream in = new FileInputStream(new File("E:\\Camera\\test.jpg"));// 指定要读取的图片  
		return in;
	}
	
	public static void copyPicture(InputStream in) throws IOException {
		 FileOutputStream out = new FileOutputStream(new File("E:\\Camera\\copytest.jpg"));// 指定要写入的图片  
	        int n = 0;// 每次读取的字节长度  
	        byte[] bb = new byte[1024];// 存储每次读取的内容  
	        while ((n = in.read(bb)) != -1) {  
	            out.write(bb, 0, n);// 将读取的内容，写入到输出流当中  
	        }  
	        out.close();// 关闭输入输出流  
	        in.close();  
	}
	
    //将byte数组写入文件  
   public static void createFile(String path, byte[] content) throws IOException {  
 
       FileOutputStream fos = new FileOutputStream(path);  
 
       fos.write(content);  
       fos.close();  
   }  
   
   public static void main(String[] args) {
	   try {
		   InputStream in=PictureUpAndDown.getPictureStream();
		   PictureUpAndDown.copyPicture(in);
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   
	
}

}
