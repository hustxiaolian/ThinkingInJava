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
		//ֱ��ʹ��ByteBuffer�ķ�����asCharBuffer���������Ϊû�н��룬������һ�����룬
		//�͸������˻�һ����Ҫôװ��ǰ�����������ã��ֺ��࣬�Է���ֱ��֪����ʶ��
		//Ҫô����װ����˵��ж����ʱ���ٸ���Լ����������ࡣ
		FileInputStream fis = new FileInputStream(new File(".\\Source\\data2.txt"));
		fc = fis.getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());//����˵����������������
		buff.rewind();//�ǲ����ø�ж������������������˼��
		
		String encode = System.getProperty("file.encoding");
		System.out.println("Decoded using " + encode + ":" + Charset.forName(encode).decode(buff));
		fc.close();
		fis.close();
		
		
		//��ûװ�����������Լ�����ã�����ֻ�ø������о�����
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
		
		//�ÿ���˾��ײ����ʱ�����
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
