package com.xiaolianhust.thinkinginjava.chapter19;

import static com.xiaolianhust.thinkinginjava.chapter19.Outcome.*;

public enum RoshaBo2 {
	PAPER(WIN, LOSE, DRAM),
	SCISSOR(LOSE, DRAM, WIN),
	ROCK(DRAM, WIN, LOSE)
	;
	private Outcome vRock;
	private Outcome vScissor;
	private Outcome vPaper;

	private RoshaBo2(Outcome vRock, Outcome vScissor, Outcome vPaper) {
		this.vRock = vRock;
		this.vScissor = vScissor;
		this.vPaper = vPaper;
	}

	public Outcome vs(RoshaBo2 other) {
		switch(other) {
		case ROCK:return vRock;
		case SCISSOR:return vScissor;
		case PAPER:return vPaper;
		}
		return null;
	}
	
	public String toString() {
		return name().toLowerCase();
	}
	
	public static RoshaBo2 rand() {
		return Enums.random(RoshaBo2.class);
	}
	
	public static void play(RoshaBo2 r1, RoshaBo2 r2) {
		System.out.println(r1 + " vs " + r2  + ":"+ r1.vs(r2));
	}

	public static void main(String[] args) {
		for(int i = 0;i < 10;++i) {
			play(rand(), rand());
		}
	}

}
