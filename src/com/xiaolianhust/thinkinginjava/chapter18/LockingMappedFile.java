package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMappedFile {
	static final int Length = 0x8FFFFFF;
	static FileChannel fc;
	
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(".\\Source\\data5.txt", "rw");
		fc = raf.getChannel();
		MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, Length);
		for(int i = 0; i < Length;++i) {
			out.put((byte)'x');
		}
		new LockAndModifyMappedFileTask(out, 0, Length / 3);
		new LockAndModifyMappedFileTask(out, Length/2, Length/2 + Length/4);//这么计算要比乘3除4更快，如果编译器不优化的话
	}
	
	private static class LockAndModifyMappedFileTask extends Thread {
		private ByteBuffer buff;
		private int start;
		private int end;
		
		public LockAndModifyMappedFileTask(ByteBuffer buff, int start, int end) {
			super();
			this.start = start;
			this.end = end;
			buff.position(start);
			buff.limit(end);
			buff = buff.slice();
			start();
		}
		
		public void run() {
			try {
				FileLock fl = fc.lock(start, end, false);
				System.out.println("Lock file from" + start + "to" + end);
				
				while(buff.position() < buff.limit() -1) {
					buff.put((byte) (buff.get() + 1));//为什么这里会需要强制转型，因为+1了，发生了基本类型的基本转型
				}
				fl.release();
				System.out.println("Release file from" + start + "to" + end);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
