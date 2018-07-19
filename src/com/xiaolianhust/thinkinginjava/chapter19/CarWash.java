package com.xiaolianhust.thinkinginjava.chapter19;

import java.util.EnumSet;

public class CarWash {
	public enum Cycle{
		UNDERBODY() {
			@Override
			public void action() {
				System.out.println("Sparying the underbody");
			}
		},
		WHEELWASH() {
			@Override
			public void action() {
				System.out.println("Washing the wheels");
			}
		},
		PREWASH(){
			@Override
			public void action() {
				System.out.println("Loosening the dirt");
			}
		},
		BASIC(){
			@Override
			public void action() {
				System.out.println("The Basic Washing");
			}
		}
		;
		public abstract void action();
	}
	private EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC);
	
	public void add(Cycle c) {
		cycles.add(c);
	}
	
	public void startWash() {
		for(Cycle c : cycles)
			c.action();
	}
	
	public static void main(String[] args) {
		CarWash cw = new CarWash();
		cw.add(Cycle.PREWASH);
		cw.startWash();
	}
	
}
