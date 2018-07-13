package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
	private static final int SIZE =  1024;
	public static void main(String[] args) throws IOException {
		//利用FileChannel来向文件中写入数据
		FileOutputStream fin = new FileOutputStream(".\\Source\\data.txt");
		FileChannel fc = fin.getChannel();//这样看起来通过不管从哪种流对象来获取的，都可以完成读写。不知道会不会报错
		fc.write(ByteBuffer.wrap("some text".getBytes()));
		fc.close();
		fin.close();
		//利用RandomAccessFile通道来完成文件的写入
		RandomAccessFile raf = new RandomAccessFile(".\\Source\\data.txt", "rw");
		fc = raf.getChannel();
		fc.position(fc.size());//将文件数据指针移动到文件末尾。
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();
		raf.close();
		//利用通道来对文件内进行写入
		FileInputStream fis = new FileInputStream(".\\Source\\data.txt");
		fc = fis.getChannel();
		ByteBuffer bf = ByteBuffer.allocate(SIZE);
		fc.read(bf);
		bf.flip();//这个方法有点不知道到底是什么意思？
		//该方法就是让缓冲器做好准备，准备好让别人来读取数据write().即从缓冲器往外面输出
		//对应的clear方法就是让缓冲器做好准备，有大佬准备往里面写数据了。外面的数据进入缓冲器，read方法
		while(bf.hasRemaining()) {
			System.out.println((char)bf.get());
		}
	}
}
