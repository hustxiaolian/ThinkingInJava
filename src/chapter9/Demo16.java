package chapter9;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class Demo16 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(new CharArrayGeneratorAdapter(7));
		while(s.hasNext()) {
			System.out.println(s.next() + "/");
		}
	}

}

class CharArrayGenerator{
	private static Random rand = new Random(47);
	private static final char[] chars = "ABCDEFGHIJKLMNOPQRTSUVWXYZ".toCharArray();
	public char next() {
		return chars[rand.nextInt(chars.length)];
	}
}

class CharArrayGeneratorAdapter extends CharArrayGenerator implements Readable{
	private int count;
	public CharArrayGeneratorAdapter(int count) {
		this.count = count;
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		if(count-- == 0)
			return -1;
		String result = String.valueOf(next()) + " ";
		cb.append(result);
		return result.length();
	}
	
}