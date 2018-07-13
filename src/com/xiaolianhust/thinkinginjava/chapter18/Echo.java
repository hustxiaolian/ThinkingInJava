package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = br.readLine()) != null && s.length() != 0) {//这里加上判断字符串不等于0，可以使得我们空输入时，停止
			System.out.println(s);
		}
		br.close();
	}
}
