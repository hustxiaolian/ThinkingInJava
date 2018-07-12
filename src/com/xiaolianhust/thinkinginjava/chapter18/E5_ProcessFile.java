package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.File;
import java.io.IOException;

import com.xiaolianhust.thinkinginjava.chapter18.ProcessFiles.ProcessStrategy;

public class E5_ProcessFile {
	private String regex;
	private ProcessStrategy processStrategy;
	public E5_ProcessFile(ProcessStrategy processStrategy, String regex) {
		this.processStrategy = processStrategy;
		this.regex = regex;
	}
	
	public void start(String[] args) {
		try {
			if(args.length == 0)
				processDirectoryTree(new File("."));
			else {
				for(String arg : args) {
					File f = new File(arg);
					if(f.isDirectory()) {
						processDirectoryTree(f);
					}
					else if(f.isFile() && f.getName().matches(regex)) {
						processStrategy.process(f);
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void processDirectoryTree(File root) throws IOException {
		for(File file : Directory.walk(root.getAbsolutePath(), regex)) {
			processStrategy.process(file);
		}
	}

}
