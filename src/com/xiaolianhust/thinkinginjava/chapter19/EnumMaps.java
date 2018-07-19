package com.xiaolianhust.thinkinginjava.chapter19;

import java.util.EnumMap;

interface Command{ void action(); }

public class EnumMaps {
	public static void main(String[] args) {
		EnumMap<AlarmPoints, Command> map = new EnumMap<>(AlarmPoints.class);
		map.put(AlarmPoints.KITCHEN, new Command() {
			
			@Override
			public void action() {
				System.out.println("Kitchen fire");
			}
		});
		
		map.put(AlarmPoints.BATHROOM, new Command() {
			
			@Override
			public void action() {
				System.out.println("Bathroom fire");
			}
		});
		
		for(AlarmPoints al : map.keySet()) {
			map.get(al).action();
		}
	}
}
