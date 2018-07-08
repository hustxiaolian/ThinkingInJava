package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.File;

public class E3_DirListCaculateSpace {
	private File filePath;

	public E3_DirListCaculateSpace(File dirPath) {
		super();
		this.filePath = dirPath;
	}
	
	public E3_DirListCaculateSpace() {
		this.filePath = new File(".");
	}
	
	public long getCurrentSpace() {
		return getCurrentSpace(filePath);
	}
	
	private long getCurrentSpace(File file) {
		long result = 0;
		if(file.isDirectory()) {
			File[] childFiles = file.listFiles();//Ð¡ÐÄ×ÐÏ¸°¡
			for(File child : childFiles) {
				result += getCurrentSpace(child);
			}
		}
		else if(file.isFile()){
			result = file.length();
		}
		return result;
	}

	public static void main(String[] args) {
		String filePath = "D:\\lammps\\Cu_load\\0705";
		System.out.println(new E3_DirListCaculateSpace(new File(filePath)).getCurrentSpace());
	}
}
