package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.File;

public class E4_DirectoriesCaculateSpace{
	public static void main(String[] args) {
		long space = 0;
		for(File f : Directory.walk(".", "*.java")) {
			space += f.length();
		}
		System.out.println(space);
	}
}
