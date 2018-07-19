package com.xiaolianhust.thinkinginjava.chapter19;

import java.util.Random;

public enum Input {
	NICKEL(5), DIME(10), QUARTER(25), DOLLER(100),
	TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
	ABORT_TRANSACTION{
		@Override
		int amount() {
			throw new RuntimeException("error 1");
		}
	},
	STOP{
		@Override
		int amount() {
			throw new RuntimeException("error 2");
		}
		
	}
	;
	int value;
	private Input() {}
	private Input(int val) { value = val;}
	int amount() {return value;}
	static Random rand = new Random();
	public static Input randomSelection() {
		return values()[rand.nextInt(values().length - 1)];//这里stop不需要
	}
}
