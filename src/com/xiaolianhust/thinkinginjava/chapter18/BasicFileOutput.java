package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {
	static String file = "BasicFileOutput.out";
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(".\\Source\\18E7.txt")));
		PrintWriter out = new PrintWriter(new FileWriter(".\\Source\\" + file));
		//这里的构造也有种快捷方式
		//PrintWriter p1 = new PrintWriter(file);
		int lineCount = 1;
		String s;
		while((s = in.readLine()) != null) {
			out.println(lineCount++ + ": " + s);
		}
		out.close();
		in.close();
		
		System.out.println(BufferedInputFile.read(".\\Source\\" + file));
	}

}
