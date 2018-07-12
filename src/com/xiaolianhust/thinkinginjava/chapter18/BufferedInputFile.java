package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
	public static String read(String filename) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		String s;
		StringBuffer sb = new StringBuffer();
		while((s = br.readLine()) != null) {
			sb.append(s).append("\n"); 
		}
		br.close();
		return sb.toString();
	}
}
