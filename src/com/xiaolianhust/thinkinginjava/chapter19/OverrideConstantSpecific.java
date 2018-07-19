package com.xiaolianhust.thinkinginjava.chapter19;

public enum OverrideConstantSpecific {
	NUT, BOLT,
	WASHER{
		public void f() {
			System.out.println("washer behavior");
		}
	}
	;
	public void f() {
		System.out.println("default hehavior");
	}
	public static void main(String[] args) {
		for(OverrideConstantSpecific ccs : OverrideConstantSpecific.values()) {
			System.out.println(ccs);
			ccs.f();
		}
	}
}
