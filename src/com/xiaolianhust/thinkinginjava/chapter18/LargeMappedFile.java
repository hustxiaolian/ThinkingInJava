package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappedFile {
	static int length = 0x8FFFFFF;
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(".\\Source\\data3.txt", "rw");
		MappedByteBuffer mbb = raf.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
		
		for(int i = 0;i < length;++i) {
			mbb.put((byte)'x');
		}
		
		for(int i = length/2;i < length/2+6;++i) {
			System.out.print((char)mbb.get(i));
		}
		
		raf.close();
	}

}
