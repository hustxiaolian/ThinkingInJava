package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class E9_ReadFileTest {
	public interface StringProcessStrategy{
		public String process(String s);
	}
	
	private StringProcessStrategy stringProcessStrategy;
	
	
	public E9_ReadFileTest(StringProcessStrategy stringProcessStrategy) {
		super();
		this.stringProcessStrategy = stringProcessStrategy;
	}
	
	public void processStringList(List<String> list) {
		for(int i = 0; i < list.size();++i) {
			list.set(i, stringProcessStrategy.process(list.get(i)));
		}
	}

	public static void main(String[] args) {
		try {
			List<String> list = new ArrayList<>(E7_ReadFileTest.readFileToList(".\\Source\\18E7.txt"));
			new E9_ReadFileTest(new StringProcessStrategy() {	
				@Override
				public String process(String s) {
					return s.toUpperCase();
				}
			}).processStringList(list);
			
			System.out.println(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
