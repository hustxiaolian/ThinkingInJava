package com.xiaolianhust.thinkinginjava.chapter18;

import java.util.HashMap;

public class E17_FileCharaterCounter {
	
	public static HashMap<Character, Integer> countDiffChar(String fileName) {
		HashMap<Character, Integer> map = new HashMap<>();
		String text = TextFile.read(fileName);
		int n = text.length();
		for(int i = 0;i < n;++i) {
			char ch = text.charAt(i);
			if(!map.containsKey(ch))
				map.put(ch, 0);
			map.replace(ch, map.get(ch) + 1);
		}
		return map;
	}
	
	public static void main(String[] args) {
		System.out.println(countDiffChar(".\\Source\\18E7.txt"));
	}
}
