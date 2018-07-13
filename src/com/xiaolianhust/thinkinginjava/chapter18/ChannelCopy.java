package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {

	public static void main(String[] args) throws IOException {
		FileInputStream ins = new FileInputStream(".\\Source\\data.txt");
		FileOutputStream outs = new FileOutputStream(".\\Source\\data1.txt");
		FileChannel in = ins.getChannel();
		FileChannel out = outs.getChannel();
		
		ByteBuffer buff = ByteBuffer.allocate(1024);
		while(in.read(buff) != -1) {
			buff.flip();
			out.write(buff);
			buff.clear();
		}
		
		//in.transferTo(0, in.size(), out);这种才是更加简单的方式。
		
		in.close();
		out.close();
		ins.close();
		outs.close();
	}

}
