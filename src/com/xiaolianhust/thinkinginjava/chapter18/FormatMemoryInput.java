package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormatMemoryInput {

	public static void main(String[] args) throws IOException {
		final String path = ".\\Source\\18E7.txt";
		DataInputStream dis = new DataInputStream(
				new ByteArrayInputStream(BufferedInputFile.read(path).getBytes()));
		byte b;
		while((b = dis.readByte()) != -1) {
			System.out.println(b);
		}
	}

}
