package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBinaryFile {
	public static byte[] read(String fileName) {
		try {
			BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(new File(fileName).getAbsoluteFile()));
			try {
				byte[] data = new byte[in.available()];
				in.read(data);
				return data;
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
