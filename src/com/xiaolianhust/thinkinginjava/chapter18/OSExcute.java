package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OSExcute {
	
	public static void command(String command) throws IOException {
		Process process = new ProcessBuilder(command.split(" ")).start();//这里记得学习记忆下。
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"D:\\eclipse\\ThinkingInJavaAgain\\Source\\Osexcute")));
		//为了获取程序执行产生的标准输出流，我们使用getInputStream
		String s;
		while((s = br.readLine()) != null) {
			pw.println(s);
		}
		pw.close();
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		command("javap OSExcute");
	}

}
