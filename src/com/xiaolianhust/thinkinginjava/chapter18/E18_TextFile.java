package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class E18_TextFile {
	public static String read(String fileName) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
		try {
			String s;
			while((s = in.readLine()) != null) {
				sb.append(s).append("\n");
			}
		} finally {
			in.close();
		}
		return sb.toString();
	}
	
	public static void write(String fileName, String text) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName).getAbsoluteFile())));
		try {
			out.print(text);
		} finally {
			out.close();
		}
	}
}
