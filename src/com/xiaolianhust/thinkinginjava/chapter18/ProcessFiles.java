package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {
	public interface ProcessStrategy{
		public void process(File file);
	}
	
	private ProcessStrategy processStrategy;
	private String ext;
	
	public ProcessFiles(ProcessStrategy processStrategy, String ext) {
		super();
		this.processStrategy = processStrategy;
		this.ext = ext;
	}
	
	public void start(String[] args) {
		try {
			if(args.length == 0)
				processDirectoryTree(new File("."));
			else {
				for(String arg : args) {
					File fileArg = new File(arg);
					if(fileArg.isDirectory())
						processDirectoryTree(fileArg);
					else {
						if(!arg.endsWith("." + ext))
							arg += "." + ext;
						processStrategy.process(new File(arg).getCanonicalFile());
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void processDirectoryTree(File root) throws IOException {
		for(File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
			processStrategy.process(file);
		}
	}
}
