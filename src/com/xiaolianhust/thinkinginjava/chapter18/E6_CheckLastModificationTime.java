package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.File;

public class E6_CheckLastModificationTime {
	public static void main(String[] args) {
		
		ProcessFiles pf = new ProcessFiles(new ProcessFiles.ProcessStrategy() {
			
			@Override
			public void process(File file) {
				
			}
		}, "java");
	}
}


