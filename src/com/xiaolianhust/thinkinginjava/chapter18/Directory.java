package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Directory {

	public static File[] local(File dir, String regex) {
		return dir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				Pattern p = Pattern.compile(regex);
				return p.matcher(name).matches();
			}
		});
	}
	
	public static File[] local(String path, String regex) {
		return local(new File(path), regex);
	}
	
	public static class TreeInfo implements Iterable<File>{
		private List<File> files= new ArrayList<>();
		private List<File> dirs = new ArrayList<>();

		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}
		
		public void addAll(TreeInfo other) {
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
	}
	
	public static TreeInfo walk(String start, String regex) {
		return recurseDirs(new File(start), regex);
	}
	
	private static TreeInfo recurseDirs(File file, String regex) {
		TreeInfo result = new TreeInfo();
		
		for(File item : file.listFiles()) {
			if(item.isDirectory()) {
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			}
			else {
				if(item.getName().matches(regex))
					result.files.add(item);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
