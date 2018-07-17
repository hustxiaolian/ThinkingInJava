package com.xiaolianhust.thinkinginjava.chapter19;

import com.xiaolianhust.thinkinginjava.chapter19.Color;

public class E1_TrafficLight {
	private Color color = Color.RED;
	
	public void change() {
		switch(color) {
		case RED:color = Color.GREEM;break;
		case GREEM:color = Color.YELLOW;break;
		case YELLOW:color = Color.RED;break;
		}
	}
	
	
	
	@Override
	public String toString() {
		return "E3_TrafficLight [color=" + color + "]";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E1_TrafficLight t = new E1_TrafficLight();
		for(int i = 0;i < 10;++i) {
			System.out.println(t);
			t.change();
		}
	}

}
