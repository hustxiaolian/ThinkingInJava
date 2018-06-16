package chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo10 {
	
	/**
	 * matches()将判断整个输入字符串是否匹配正则表达式
	 * lookingAt()将判断字符串的起始位置是否匹配正则表达式
	 * find()方法将寻找字符串中能够匹配正则表达式的所有起始位置
	 * find(int start)人为指定开始寻找的起始位置
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Java now has regular expressions\n";
		String[] regexs = {"^Java","\\Breg.*","n.","n.w\\s+h(a|i)s", "s?","s*","s+","s{4}","s{1}.","s{0,3}"};
		for(String regex : regexs) {
			System.out.printf("for regex:%s\n",regex);
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(input);
			while(m.find()) {
				System.out.printf("Match\"%s\" at position %d - %d\n",m.group(), m.start(), m.end() - 1);
			}
			
		}
	}

}
