package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringReader sr = new StringReader(BufferedInputFile.read(".\\Source\\18E7.txt"));
		int c;
		while((c = sr.read()) != -1) {
			System.out.format("0x%x ", c);
		}
	}

}
