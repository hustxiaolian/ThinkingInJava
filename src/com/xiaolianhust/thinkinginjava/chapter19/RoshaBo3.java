package com.xiaolianhust.thinkinginjava.chapter19;

public enum RoshaBo3 {
	PAPER {
		@Override
		Outcome vs(RoshaBo3 other) {
			switch(other) {
			case PAPER:return Outcome.DRAM;
			case ROCK:return Outcome.WIN;
			default:return Outcome.LOSE;
			}
		}
	},
	ROCK{
		@Override
		Outcome vs(RoshaBo3 other) {
			switch(other) {
			case PAPER:return Outcome.LOSE;
			case ROCK:return Outcome.DRAM;
			default:return Outcome.WIN;
			}
		}
	},
	SCISSOR{
		@Override
		Outcome vs(RoshaBo3 other) {
			switch(other) {
			case PAPER:return Outcome.WIN;
			case ROCK:return Outcome.LOSE;
			default:return Outcome.DRAM;
			}
		}
	}
	;
	abstract Outcome vs(RoshaBo3 other);
	
	public static void play(RoshaBo3 r1, RoshaBo3 r2) {
		System.out.println(r1 + " vs " + r2 + ":" + r1.vs(r2));
	}
}
