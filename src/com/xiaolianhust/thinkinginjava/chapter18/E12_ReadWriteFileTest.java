package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class E12_ReadWriteFileTest {
	/**
	 * 
	 * @param inFileName
	 * @param outFileName
	 * @param strategy
	 */
	public static void readFileThenProcessLineAndWriter(String inFileName, String outFileName,
			E9_ReadFileTest.StringProcessStrategy strategy) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(inFileName)));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFileName)));
		
		String s, w;
		LinkedList<String> lineList = new LinkedList<>();
		while((s = br.readLine()) != null) {
			lineList.add(s);
		}
		for (String string : lineList) {
			pw.println(strategy.process(string));
		}
		pw.close();
		br.close();
	}
	
	
	
	public static void main(String[] args) throws IOException {
		readFileThenProcessLineAndWriter(".\\Source\\18E7.txt", ".\\Source\\18E12.txt", new E9_ReadFileTest.StringProcessStrategy() {
			int countNum = 1;
			@Override
			public String process(String s) {
				return countNum++ + ": " + s;
			}
		});
	}
}
