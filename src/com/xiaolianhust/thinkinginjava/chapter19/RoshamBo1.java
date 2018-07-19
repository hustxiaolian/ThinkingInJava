package com.xiaolianhust.thinkinginjava.chapter19;

import java.util.Random;

import com.sun.javafx.geom.transform.BaseTransform.Degree;

import chapter15.Generator;

interface Item{
	Outcome compare(Item i);
	Outcome eval(Paper p);
	Outcome eval(Scissors s);
	Outcome eval(Rock r);
}

/*
 * �������ýӿڵķ�ʽ��ʵ�ֶ�·�ַ���compare���������ṩ��ͬһ�Ľӿڣ�ͬʱ��ͨ����̬���ƣ����ֵ����ߵ����ͣ�Ȼ����
 * ���÷�����������ɶԵڶ�����̬�жϣ��ɴ���ɶ�·�ַ���
 */

class Paper implements Item{

	@Override
	public Outcome compare(Item i) {
		return i.eval(this);
	}

	@Override
	public Outcome eval(Paper p) {
		return Outcome.DRAM;
	}

	@Override
	public Outcome eval(Scissors s) {
		return Outcome.LOSE;
	}

	@Override
	public Outcome eval(Rock r) {
		return Outcome.WIN;
	}

	@Override
	public String toString() {
		return "Paper";
	}
	
	
}

class Scissors implements Item{

	@Override
	public Outcome compare(Item i) {
		return i.eval(this);
	}

	@Override
	public Outcome eval(Paper p) {
		return Outcome.WIN;
	}

	@Override
	public Outcome eval(Scissors s) {
		return Outcome.DRAM;
	}

	@Override
	public Outcome eval(Rock r) {
		return Outcome.LOSE;
	}

	@Override
	public String toString() {
		return "Scissors";
	}
	
}

class Rock implements Item{

	@Override
	public Outcome compare(Item i) {
		return i.eval(this);
	}

	@Override
	public Outcome eval(Paper p) {
		return Outcome.LOSE;
	}

	@Override
	public Outcome eval(Scissors s) {
		return Outcome.WIN;
	}

	@Override
	public Outcome eval(Rock r) {
		return Outcome.DRAM;
	}

	@Override
	public String toString() {
		return "Rock";
	}
	
}

public class RoshamBo1 {
	public static Generator<Item> itemGenerator(){
		return new Generator<Item>() {
			Random rand = new Random();//�����ڲ��಻����static��Ա���Ͼ���֪����ľ������������Ҳû����
			@Override
			public Item next() {
				switch(rand.nextInt(3)) {
				case 0: return new Rock();
				case 1: return new Scissors();
				default: return new Paper();
				}
			}
		};
	}
	
	
	
	public static void vs(Item i1,Item i2) {
		System.out.println(i1 + " vs " + i2 + ": " + i1.compare(i2));
	}
	
	public static void main(String[] args) {
		Generator<Item> gen1 = itemGenerator();
		Generator<Item> gen2 = itemGenerator();
		for(int i = 0; i < 10;++i) {
			vs(gen1.next(), gen2.next());
		}
	}
}
