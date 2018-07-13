package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E21_StdIn {
	
	public static String readFromstdin() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String s;
		while((s = br.readLine()) != null && s.length() != 0) {
			sb.append(s).append("\n");
		}
		br.close();
		return sb.toString().toUpperCase();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(readFromstdin());
	}

}
