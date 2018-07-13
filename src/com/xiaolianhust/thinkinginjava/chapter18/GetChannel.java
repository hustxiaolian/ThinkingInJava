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
		//����FileChannel�����ļ���д������
		FileOutputStream fin = new FileOutputStream(".\\Source\\data.txt");
		FileChannel fc = fin.getChannel();//����������ͨ�����ܴ���������������ȡ�ģ���������ɶ�д����֪���᲻�ᱨ��
		fc.write(ByteBuffer.wrap("some text".getBytes()));
		fc.close();
		fin.close();
		//����RandomAccessFileͨ��������ļ���д��
		RandomAccessFile raf = new RandomAccessFile(".\\Source\\data.txt", "rw");
		fc = raf.getChannel();
		fc.position(fc.size());//���ļ�����ָ���ƶ����ļ�ĩβ��
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();
		raf.close();
		//����ͨ�������ļ��ڽ���д��
		FileInputStream fis = new FileInputStream(".\\Source\\data.txt");
		fc = fis.getChannel();
		ByteBuffer bf = ByteBuffer.allocate(SIZE);
		fc.read(bf);
		bf.flip();//��������е㲻֪��������ʲô��˼��
		//�÷��������û���������׼����׼�����ñ�������ȡ����write().���ӻ��������������
		//��Ӧ��clear���������û���������׼�����д���׼��������д�����ˡ���������ݽ��뻺������read����
		while(bf.hasRemaining()) {
			System.out.println((char)bf.get());
		}
	}
}
