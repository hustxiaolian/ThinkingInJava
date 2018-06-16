package chapter13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo15 {
	public static void main(String[] args) {
		try {
			JGrep.doit(args);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class JGrep{
	public static void doit(String[] args) throws IOException {
		if(args.length < 3) {
			System.out.println("Usage:java Demo15 file regex option(0 - 2)");
			System.exit(0);
		}
		Pattern p = null;
		switch(Integer.valueOf(args[2])) {
		case 0:
			p = Pattern.compile(args[1]);break;
		case 1:
			p = Pattern.compile(args[1], Pattern.CASE_INSENSITIVE);break;
		case 2:
			p = Pattern.compile(args[1], Pattern.MULTILINE);break;
		default:
			System.exit(0);
		}
		Matcher m = p.matcher("");
		int index = 1;
		FileReader fr = new FileReader("Demo15.java");
		BufferedReader br = new BufferedReader(fr);
		Formatter format = new Formatter(System.out);
		String line = "";
		format.format("%-5s %-20.20s %-5s", "i", "successpart", "in");
		while((line = br.readLine()) != null) {
			m.reset(line);
			while(m.find()) {
				format.format("%-5d %-20.20s %-5d\n", ++index, m.group(), m.start());
			}
		}
		format.close();
		br.close();
		fr.close();
	}
}