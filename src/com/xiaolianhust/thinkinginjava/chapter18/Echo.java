package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = br.readLine()) != null && s.length() != 0) {//��������ж��ַ���������0������ʹ�����ǿ�����ʱ��ֹͣ
			System.out.println(s);
		}
		br.close();
	}
}
