package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.IOException;

public class E8_ReadFileTest {
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("请只输入文件的路径");
			System.exit(-1);
		}
		try {
			System.out.println(E7_ReadFileTest.readFileToList(args[0]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
