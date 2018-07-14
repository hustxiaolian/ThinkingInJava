package com.xiaolianhust.thinkinginjava.chapter19;

enum Shrubbery{
	GROUND, CRAWLING, HANDING
}

public class EnumClass {
	public static void main(String[] args) {
		for(Shrubbery s : Shrubbery.values()) {
			System.out.println(s + " ordinal" + s.ordinal());//返回数组索引
			System.out.println(s.compareTo(Shrubbery.CRAWLING) + " ");
			System.out.println(s.equals(Shrubbery.CRAWLING) + " ");
			System.out.println(s == Shrubbery.CRAWLING);
			System.out.println(s.getDeclaringClass().getSimpleName());
			System.out.println(s.name());
			System.out.println("--------------");
		}
		
		//还可以从String中转换到enum类型
		for(String s : "GROUND CRAWLING HANDING".split(" ")) {
			Shrubbery shru = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shru);
		}
	}
}
