package chapter8;

import java.util.Random;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cycle[] c = new Cycle[10];
		RandomCycleGenerator r = new RandomCycleGenerator();
		for (Cycle cycle : c) {
			cycle = r.next();
			cycle.ride();
		}
	}

}

class RandomCycleGenerator {
	private Random rand = new Random();
	public Cycle next() {
		switch(rand.nextInt(3)) {
		case 0: return new Unicycle();
		case 1: return new Bicycle();
		case 2: return new Tricycle();
		}
		return new Cycle();
	}
}