package chapter17;

import java.util.BitSet;

public class Bits {
	public static void printBitSet(BitSet b) {
		System.out.println("bits: " + b);
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < b.size();++i) {
			sb.append(b.get(i) ? "1" : "0");
		}
		System.out.println("bit pattern: " + sb);
	}
	
	public static void main(String[] args) {
		
	}
}
