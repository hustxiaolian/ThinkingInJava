package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFile extends ArrayList<String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//����try-catch��try-finally����ϻ������ǹ����ַ���Ҫ��ס��
	public static String read(String fileName) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			try {
				String s;
				while((s = in.readLine()) != null) {
					sb.append(s).append("\n");
				}
			}
			finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
	
	public static void write(String name, String text) {
		try {
			PrintWriter out = new PrintWriter(
					new BufferedWriter(new FileWriter(new File(name).getAbsoluteFile())));
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	/***
	 * ��������read��ͬʱ���һ����ֵĲ���
	 * @param fileName
	 * @param splitter
	 */
	public TextFile(String fileName, String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));
		if(get(0).equals("")) remove(0);
	}
	
	public TextFile(String fileName) {
		this(fileName, "\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
