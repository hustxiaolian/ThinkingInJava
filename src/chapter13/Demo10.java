package chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo10 {
	
	/**
	 * matches()���ж����������ַ����Ƿ�ƥ��������ʽ
	 * lookingAt()���ж��ַ�������ʼλ���Ƿ�ƥ��������ʽ
	 * find()������Ѱ���ַ������ܹ�ƥ��������ʽ��������ʼλ��
	 * find(int start)��Ϊָ����ʼѰ�ҵ���ʼλ��
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
