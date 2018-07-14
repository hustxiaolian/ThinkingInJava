package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipCompree {
	public static void main(String[] args) throws IOException {
		//����װ����ģʽ����������Ҫ��ѹ����������󣬺���IO��FileOutputStream
		FileOutputStream fos = new FileOutputStream(".\\Soruce\\test.zip");
		CheckedOutputStream cos = new CheckedOutputStream(fos, new Adler32());
		ZipOutputStream zos = new ZipOutputStream(cos);
		BufferedOutputStream bos = new BufferedOutputStream(zos);
		
		zos.setComment("a test of zip compreee");//ѹ��ע��
		//ÿ��ѹ����ͬ���ļ�ʱ����ҪҪ���õ�ǰZipOutputStream�����putNextEntry(new ZipEntry())����
		for(String  arg : args) {
			BufferedReader br = new BufferedReader(new FileReader(arg));
			zos.putNextEntry(new ZipEntry(arg));
			int c;
			while((c = br.read()) != -1)
				bos.write(c);
			br.close();
			bos.flush();//��ʱˢ��
		}
		
		bos.close();//Ӧ����ֻҪ�ر����ľ��У��ҹ������ڲ���һ�ε���close�ر�ֱ������IO�ر�
		
		FileInputStream fis = new FileInputStream(".\\Source\\test.zip");
		CheckedInputStream cis = new CheckedInputStream(fis, new Adler32());
		ZipInputStream zis = new ZipInputStream(cis);
		BufferedInputStream bis = new BufferedInputStream(cis);
		//��ѹ��ÿ���ļ���
		ZipEntry entry;
		while((entry = zis.getNextEntry()) != null) {
			int c;
			System.out.println("Reading file: " + entry);
			while((c = bis.read()) != -1) {
				System.out.println(c);
			}
		}
		
		bis.close();
	}
}
