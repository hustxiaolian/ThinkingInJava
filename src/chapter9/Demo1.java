package chapter9;

import java.util.Random;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomRodentGenerator r = new RandomRodentGenerator();
		Rodent[] ro = new Rodent[3];
		for (Rodent rodent : ro) {
			rodent = r.next();
			rodent.eat(Food.MEAT);
			System.out.println();
		}
		//Rodent r1 = new Rodent();
	}

}

class RandomRodentGenerator {
	private Random rand = new Random();
	public Rodent next() {
		switch(rand.nextInt(3)) {
		case 0: return new Mouse();
		case 1: return new Gerbli();
		case 2: return new Hamster();
		}
		return null;
	}
}

abstract class Rodent{
	public abstract void eat(Food f);
}

enum Food{
	MEAT, VEGETABLE, FRUIT;
}

class Mouse extends Rodent{
	public Mouse() {
		System.out.println("Mouse");
	}
	public void eat(Food f) {
		System.out.println("Mouse eat " + f);
	}
}

class Gerbli extends Rodent{
	public Gerbli() {
		System.out.println("Gerbli");
	}
	public void eat(Food f) {
		System.out.println("Gerbli eat " + f);
	}
}
class Hamster extends Rodent{
	public Hamster() {
		System.out.println("Hamster");
	}
	public void eat(Food f) {
		System.out.println("Hamster eat " + f);
	}
}
