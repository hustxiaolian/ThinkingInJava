package chapter15;

import chapter14.Cat;
import chapter14.Dog;

public class E3_SixTuple<A, B, C, D, E, F> extends TwoTuple<A, B> {
	public final C third;
	public final D fourth;
	public final E fifth;
	public final F sixth;
	
	

	public E3_SixTuple(A first, B second, C third, D fourth, E fifth, F sixth) {
		super(first, second);
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		this.sixth = sixth;
	}

	public E3_SixTuple<String, Integer, Float, Double, Dog, Cat> sixTupleTest() {
		return new E3_SixTuple<String, Integer, Float, Double, Dog, Cat>(
				"xiaolian",3, 3.0f, 3.0, new Dog("mo ye"), new Cat("xiao ding"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
