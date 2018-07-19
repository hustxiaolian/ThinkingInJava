package com.xiaolianhust.thinkinginjava.chapter19;

import java.util.EnumMap;
import static com.xiaolianhust.thinkinginjava.chapter19.Outcome.*;
public enum RoshaBo5 {
	PAPER, ROCK, SCISSOR
	;
	static EnumMap<RoshaBo5, EnumMap<RoshaBo5, Outcome>> table = new EnumMap<>(RoshaBo5.class);
	static {
		for(RoshaBo5 r : RoshaBo5.values()) {
			table.put(r, new EnumMap<>(RoshaBo5.class));
		}
		initRow(PAPER, DRAM, LOSE, WIN);
		initRow(ROCK, LOSE, DRAM, WIN);
		initRow(SCISSOR, WIN, LOSE, DRAM);
	}
	private static void initRow(RoshaBo5 r1, Outcome... res) {
		EnumMap<RoshaBo5, Outcome> currSubMap = table.get(r1);
		int i = 0;
		if(res.length != RoshaBo5.values().length)
			throw new RuntimeException("must equal");
		for(RoshaBo5 r : RoshaBo5.values()) {
			currSubMap.put(r, res[i++]);
		}
	}
	
	public static RoshaBo5 randRoshaBo() {
		return Enums.random(RoshaBo5.class);
	}
	
	public static Outcome play(RoshaBo5 r1 ,RoshaBo5 r2) {
		return table.get(r1).get(r2);
	}
	
	public static void vs(RoshaBo5 r1 ,RoshaBo5 r2) {
		System.out.println(r1 + " vs " + r2 + ":" + play(r1, r2));
	}
	
	public static void main(String[] args) {
		for(int i = 0;i < 10; ++i) {
			vs(randRoshaBo(), randRoshaBo());
		}
	}
}
