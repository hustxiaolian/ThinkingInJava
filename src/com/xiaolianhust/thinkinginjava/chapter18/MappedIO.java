package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 
 * @author 25040
 *
 */
public class MappedIO {
	public static int numOfInts = 4000000;
	public static int numOfbuffInts = 200000;
	private static String path = ".\\Souece\\data.txt";
	public abstract static class IOTester{
		private String name;

		public IOTester(String name) {
			super();
			this.name = name;
		}
		//模板方法设计模式，基类方法，不变的部分抽象出来
		public void runTest() {
			System.out.println(name + ": ");
			try {
				long start = System.nanoTime();
				test();
				System.out.println(System.nanoTime() - start);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		//变动的部分
		public abstract void test() throws IOException;
	}
	
	private static IOTester[] tests = {
		new IOTester("Stream Write") {
			@Override
			public void test() throws IOException {
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
						new FileOutputStream(path)));
				for(int i = 0;i < numOfInts;++i) {
					dos.writeInt(i);
				}
				dos.close();
			}
		},
		
		new IOTester("Mapped Write") {
			
			@Override
			public void test() throws IOException {
				RandomAccessFile raf = new RandomAccessFile(path, "rw");
				FileChannel fc = raf.getChannel();
				MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size());
				for(int i = 0;i < numOfInts;++i)
					mbb.putInt(i);
				fc.close();
				raf.close();
			}
		},
		
		new IOTester("Stream Read") {
			
			@Override
			public void test() throws IOException {
				DataInputStream dis = new DataInputStream(new BufferedInputStream(
						new FileInputStream(path)));
				for(int i = 0;i < numOfInts;++i)
					dis.readInt();
				dis.close();
			}
		},
		
		new IOTester("Mapped Read") {
			
			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				RandomAccessFile raf = new RandomAccessFile(path, "r");
				FileChannel fc = raf.getChannel();
				MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
				
				for(int i = 0; i < numOfInts;++i)
					mbb.getInt();
				
				fc.close();
				raf.close();
			}
		}
		
		
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
