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
		//利用装饰器模式构建我们需要的压缩输出流对象，核心IO是FileOutputStream
		FileOutputStream fos = new FileOutputStream(".\\Soruce\\test.zip");
		CheckedOutputStream cos = new CheckedOutputStream(fos, new Adler32());
		ZipOutputStream zos = new ZipOutputStream(cos);
		BufferedOutputStream bos = new BufferedOutputStream(zos);
		
		zos.setComment("a test of zip compreee");//压缩注释
		//每次压缩不同的文件时，都要要调用当前ZipOutputStream对象的putNextEntry(new ZipEntry())方法
		for(String  arg : args) {
			BufferedReader br = new BufferedReader(new FileReader(arg));
			zos.putNextEntry(new ZipEntry(arg));
			int c;
			while((c = br.read()) != -1)
				bos.write(c);
			br.close();
			bos.flush();//及时刷新
		}
		
		bos.close();//应该是只要关闭最顶层的就行，我估计它内部会一次调用close关闭直至核心IO关闭
		
		FileInputStream fis = new FileInputStream(".\\Source\\test.zip");
		CheckedInputStream cis = new CheckedInputStream(fis, new Adler32());
		ZipInputStream zis = new ZipInputStream(cis);
		BufferedInputStream bis = new BufferedInputStream(cis);
		//解压缩每个文件，
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
