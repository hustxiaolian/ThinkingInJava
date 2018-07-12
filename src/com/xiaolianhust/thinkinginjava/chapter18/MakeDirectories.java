package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.File;
import java.io.IOException;

public class MakeDirectories {
	private static void fileData(File f) throws IOException {
		System.out.println(""
				+ "Absolute path:" + f.getAbsolutePath()
				+ "\n Can Read:" + f.canRead()
				+ "\n Can Write:" + f.canWrite()
				+ "\n getName:" + f.getName()
				+ "\n getParent:" + f.getParent()
				+ "\n getPath:" + f.getPath()
				+ "\n length:" + f.length()
				+ "\n lastModified:" + f.lastModified()
				+ "\n getCancialPath:" + f.getCanonicalPath()
				);
		if(f.isDirectory())
			System.out.println("is Dir");
		else if(f.isFile())
			System.out.println("is File");
	}
	
	public static void main(String[] args) {
		try {
			fileData(new File("."));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
