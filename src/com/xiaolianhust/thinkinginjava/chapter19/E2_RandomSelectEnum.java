package com.xiaolianhust.thinkinginjava.chapter19;

import java.util.Random;

import chapter15.Generator;

enum CartoonCharacter implements Generator<CartoonCharacter>{
	SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB
	;
	private static Random rand = new Random(47);
	
	@Override
	public CartoonCharacter next() {
		return values()[rand.nextInt(values().length)];
	}
	
	public static CartoonCharacter nextCartoonCharacter() {
		return values()[rand.nextInt(values().length)];
	}
}

public class E2_RandomSelectEnum {
	public static <T> void printNext(Generator<T> gen) {
		System.out.println(gen.next() + " ");
	}
	
	public static void main(String[] args) {
		CartoonCharacter cc = CartoonCharacter.BOB;
		for(int i = 0;i < 10;++i) {
			printNext(cc);
		}
		
		for(int i = 0;i < 10;++i) {
			System.out.println(CartoonCharacter.nextCartoonCharacter());
		}
	}
}
