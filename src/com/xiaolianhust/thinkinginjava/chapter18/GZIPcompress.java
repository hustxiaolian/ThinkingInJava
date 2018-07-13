package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {

	public static void main(String[] args) throws IOException {
		if(args.length == 0) {
			System.out.println("Usage:");
			System.exit(-1);
		}
		
		//压缩文件写入
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		BufferedOutputStream bos = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(".\\Source\\test.gz")));
		System.out.println("Writing file");
		int c;
		while((c = br.read()) != -1) {
			bos.write(c);
		}
		bos.close();
		br.close();
		
		//压缩文件读取
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(".\\Source\\test.gz"))));
		String s;
		while((s = br2.readLine()) != null)
			System.out.println(s);
		br2.close();
	}

}
