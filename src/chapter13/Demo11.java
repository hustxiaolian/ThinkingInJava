package chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo11 {
	public static void main(String[] args) {
		String input = "Arline ate eight apples and one orange while Anita hadn't any";
		String regex = "(?i)((^[aeiou])|(\\s+[aeiou])\\w+?[aeiou]\\b)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while(m.find()) {
			System.out.printf("Match \"%s\" at position %d - %d\n", m.group(), m.start(), m.end() - 1);
		}
	}
}
