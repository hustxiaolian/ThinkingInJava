package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class E7_ReadFileTest {
	
	public static LinkedList<String> readFileToList(String filename) throws IOException{
		LinkedList<String> result = new LinkedList<>();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String s;
		while((s = br.readLine()) != null) {
			result.add(s);
		}
		br.close();
		Collections.reverse(result);
		return result;
	}
	
	
	public static void main(String[] args) {
		try {
			System.out.println(readFileToList(".\\Source\\18E7.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
