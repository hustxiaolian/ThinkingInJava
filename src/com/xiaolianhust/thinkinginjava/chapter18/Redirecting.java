package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Redirecting {
	public static void main(String[] args) throws IOException {
		PrintStream console = System.out;
		InputStream stdin = System.in;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				".\\src\\com\\xiaolianhust\\thinkinginjava\\chapter18\\Redirecting.java"));
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(".\\Source\\test.out")));
		
		System.setIn(in);
		System.setOut(out);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = br.readLine()) != null) {
			System.out.println(s);//重定向后实际上输出到文件中去了。
		}
		
		in.close();
		out.close();
		System.setIn(stdin);
		System.setOut(console);
	}
}
