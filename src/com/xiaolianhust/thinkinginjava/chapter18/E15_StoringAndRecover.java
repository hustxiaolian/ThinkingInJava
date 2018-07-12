package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class E15_StoringAndRecover {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(".\\Source\\E15out")));
		out.writeDouble(3.1415);
		out.writeUTF("this is pi.");
		out.writeDouble(1.414);
		out.writeUTF("square root if 2");
		out.close();
		
		
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream(".\\Source\\E15out")));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		
		in.close();
	}

}
