package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E2_SortedDirList {
	private File dirPath;

	public E2_SortedDirList(File dirPath) {
		super();
		this.dirPath = dirPath;
	}
	
	public E2_SortedDirList() {
		this(new File("."));
	}
	
	public String[] list(String regex) {
		String[] list = dirPath.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(name);
				return m.matches();
			}
		});
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		return list;
	}
	
	public String[] list() {
		String[] list = dirPath.list();
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		return list;
	}
}
