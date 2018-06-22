package chapter15;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class E13_FillCollection {
	public static <T> List<T> fill(List<T> lst, Generator<T> gen, int n) {
		for (int i = 0; i < n; i++) {
			lst.add(gen.next());
		}
		return lst;
	}
	
	public static <T> Queue<T> fill(Queue<T> queue, Generator<T> gen, int n) {
		for (int i = 0; i < n; i++) {
			queue.add(gen.next());
		}
		return queue;
	}
	
	public static <T> Set<T> fill(Set<T> set, Generator<T> gen, int n) {
		for (int i = 0; i < n; i++) {
			set.add(gen.next());
		}
		return set;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
