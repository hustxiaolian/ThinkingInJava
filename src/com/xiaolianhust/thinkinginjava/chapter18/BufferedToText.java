package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferedToText {
	public static final int BSIZE = 1024;
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(".\\Source\\data2.txt"));
		FileChannel fc = fos.getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		fos.close();
		//直接使用ByteBuffer的方法的asCharBuffer尝试输出因为没有解码，而出现一堆乱码，
		//就跟卡车运货一样，要么装车前整整齐齐的码好，分好类，对方能直接知道和识别
		//要么就先装了再说，卸货的时候再根据约定，解码分类。
		FileInputStream fis = new FileInputStream(new File(".\\Source\\data2.txt"));
		fc = fis.getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());//书上说这样会产生乱码错误。
		buff.rewind();//是不是拿刚卸货的数据重新填充的意思。
		
		String encode = System.getProperty("file.encoding");
		System.out.println("Decoded using " + encode + ":" + Charset.forName(encode).decode(buff));
		fc.close();
		fis.close();
		
		
		//还没装车，发货方自己编码好，卡车只用负责运行就行了
		fos = new FileOutputStream(new File(".\\Source\\data2.txt"));
		fc = fos.getChannel();
		buff = ByteBuffer.wrap("some text".getBytes("UTF-16BE"));
		fc.write(buff);
		fc.close();
		fos.close();
		
		fis = new FileInputStream(new File(".\\Source\\data2.txt"));
		fc = fis.getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		
		fc.close();
		fis.close();
		
		//让卡车司机撞车的时候编码
		fos = new FileOutputStream(new File(".\\Source\\data2.txt"));
		fc = fos.getChannel();
		buff = ByteBuffer.allocate(24);
		buff.asCharBuffer().put("some text");
		fc.write(buff);
		fc.close();
		fos.close();
		
		fis = new FileInputStream(new File(".\\Source\\data2.txt"));
		fc = fis.getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		
		fc.close();
		fis.close();
		
	}

}
