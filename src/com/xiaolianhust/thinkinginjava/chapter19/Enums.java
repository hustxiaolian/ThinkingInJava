package com.xiaolianhust.thinkinginjava.chapter19;

import java.util.Random;

public class Enums {
	private static Random rand = new Random();
	public static <T extends Enum<T>> T random(Class<T> cls) {
		return random(cls.getEnumConstants());
	}
	
	public static <T> T random(T[] values) {
		return values[rand.nextInt(values.length)];
	} 
}
