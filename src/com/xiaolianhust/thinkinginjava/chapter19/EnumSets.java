package com.xiaolianhust.thinkinginjava.chapter19;

import java.util.EnumSet;

public class EnumSets {

	public static void main(String[] args) {
		EnumSet<AlarmPoints> set = EnumSet.noneOf(AlarmPoints.class);
		set.add(AlarmPoints.BATHROOM);
		System.out.println(set);
		set.addAll(EnumSet.of(AlarmPoints.KITCHEN, AlarmPoints.LOBBY));
		System.out.println(set);
		set.addAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
		System.out.println(set);
		
		set = EnumSet.allOf(AlarmPoints.class);
		System.out.println(set);
		set.remove(AlarmPoints.STAIR1);
		System.out.println(set);
		
		set.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
		System.out.println(set);
		
		set = EnumSet.complementOf(set);
		System.out.println(set);
	}

}
