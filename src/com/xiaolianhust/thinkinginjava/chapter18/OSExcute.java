package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OSExcute {
	
	public static void command(String command) throws IOException {
		Process process = new ProcessBuilder(command.split(" ")).start();//����ǵ�ѧϰ�����¡�
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"D:\\eclipse\\ThinkingInJavaAgain\\Source\\Osexcute")));
		//Ϊ�˻�ȡ����ִ�в����ı�׼�����������ʹ��getInputStream
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
