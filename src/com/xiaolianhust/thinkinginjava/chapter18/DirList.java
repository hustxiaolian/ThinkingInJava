package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
	public static FilenameFilter getRegexFilter(final String regex) {
		return new FilenameFilter() {//确实，将匿名内部的定义返回定义在一个单独的方法中，可能让程序更清晰，学习了
			
			@Override
			public boolean accept(File dir, String name) {
				Pattern p = Pattern.compile(regex);
				return p.matcher(name).matches();
			}
		};
	}
	
	public static void main(String[] args) {
		File path = new File(".");
		String[] list;
		if(args.length == 0)
			list = path.list();
		else
			//list = path.list(new DirFilter(args[0]));在包内定义类然后实现，
			list = path.list(getRegexFilter(args[0]));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String file : list)
			System.out.println(file);
	}
}

class DirFilter implements FilenameFilter{
	
	private Pattern pattern;
	public DirFilter(String regex) {
		this.pattern = Pattern.compile(regex);
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
}