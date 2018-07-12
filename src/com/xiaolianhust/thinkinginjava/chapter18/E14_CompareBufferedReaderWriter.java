package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class E14_CompareBufferedReaderWriter {
	static String dir = ".\\Source\\";
	public static void compareDiffWriter(PrintWriter out1, PrintWriter out2, BufferedReader in) throws IOException {
		ArrayList<String> cache = new ArrayList<>();
		String s;
		while((s = in.readLine()) != null) {
			cache.add(s);
		}
		in.close();
		
		long start1 = System.currentTimeMillis();
		for (String oneLine : cache) {
			out1.println(oneLine);
		}
		System.out.println("has buffer: " + (System.currentTimeMillis() - start1));
		out1.close();
		
		start1 = System.currentTimeMillis();
		for (String oneLine : cache) {
			out2.println(oneLine);
		}
		System.out.println("no buffer: " + (System.currentTimeMillis() - start1));
		out2.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		compareDiffWriter(new PrintWriter(new BufferedWriter(new FileWriter(new File(dir + "E14buffer")))), 
				new PrintWriter(new FileWriter(new File(dir + "nobuffered"))), 
				new BufferedReader(new FileReader("D:\\lammps\\Cu_load\\0404\\dump.moblie.atoms.version12.600K.same.load.rate.0.25.28.0.5w")));
		
		BufferedReader br = new BufferedReader(new FileReader("D:\\lammps\\Cu_load\\0404\\dump.moblie.atoms.version12.600K.same.load.rate.0.25.28.0.5w"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(dir + "direct")));
		String s;
		long start = System.currentTimeMillis();
		while((s = br.readLine()) != null) {
			pw.println(s);
		}
		System.out.println("direct: " + (System.currentTimeMillis() - start));
		pw.close();
		br.close();
	}
}
