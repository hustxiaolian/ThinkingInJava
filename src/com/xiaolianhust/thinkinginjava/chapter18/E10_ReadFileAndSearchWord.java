package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.IOException;
import java.util.List;

public class E10_ReadFileAndSearchWord {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("第一个参数位参数位文件路径，第二个参数为欲查找的单词");
			System.exit(-1);
		}
		System.out.println("args[0]: "+ args[0] + ", args[1]: " + args[1]);
		try {
			List<String> list = E7_ReadFileTest.readFileToList(args[0]);
			for(String s : list) {
				if(s.contains(args[1]))
					System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
