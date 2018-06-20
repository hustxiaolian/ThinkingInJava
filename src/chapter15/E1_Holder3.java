package chapter15;

import chapter14.Dog;
import chapter14.Pet;

class E1_Holder3<T>{
	private T a;

	public E1_Holder3(T a) {
		super();
		this.a = a;
	}

	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}
	
	public static void main(String[] args) {
		E1_Holder3<Pet> h3 = new E1_Holder3<>(new Pet());
		h3.setA(new Dog());
	}
}