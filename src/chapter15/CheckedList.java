package chapter15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chapter14.Cat;
import chapter14.Dog;

public class CheckedList {

	@SuppressWarnings({ "unchecked"})
	static void oldStyleMethod(List probablyDogs) {
		probablyDogs.add(new Cat());
	}

	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<>();
		oldStyleMethod(dogs1);
		List<Dog> dogs2 = Collections.checkedList(new ArrayList<>(), Dog.class);
		oldStyleMethod(dogs2);//难道变化了
	}
}
