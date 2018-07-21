package com.xiaolianhust.thinkinginjava.chapter20;

public class Testable {
	public void excute() {
		System.out.println("Executing.. ");
	}
	@Test
	void testExcute() {
		excute();
	}
}
