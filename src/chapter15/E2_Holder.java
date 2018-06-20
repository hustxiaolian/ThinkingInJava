package chapter15;

import chapter14.*;

public class E2_Holder<T> {
	public static final int SIZE = 3;
	private T[] a;
	
	@SuppressWarnings("unchecked")
	public E2_Holder() {
		this.a = (T[]) new Object[SIZE];
	}
	
	public E2_Holder(T[] a) {
		super();
		if(a.length != 3)
			return;
		this.a = a;
	}

	public T get(int index) {
		if(index < 0 || index > 2)
			throw new ArrayIndexOutOfBoundsException();
		return a[index];
	}
	
	public T set(int index, T newVal) {
		if(index < 0 || index > 2)
			throw new ArrayIndexOutOfBoundsException();
		T old = a[index];
		a[index] = newVal;
		return old;
	}

	public static void main(String[] args) {
		E2_Holder<Pet> h4 = new E2_Holder<>();
		h4.set(0, new Dog("mo ye"));
		h4.set(1, new Dog("jiu gui"));
		h4.set(2, new Cat("da ding"));
		
		System.out.println(h4.get(0));
	}

}
