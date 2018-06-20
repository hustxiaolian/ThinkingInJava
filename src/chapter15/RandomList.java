package chapter15;


import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
	private ArrayList<T> storage = new ArrayList<>();
	private Random rand = new Random();
	
	public void add(T item) {
		storage.add(item);
	}
	
	public T select() {
		return storage.get(rand.nextInt(storage.size()));
	}
}
