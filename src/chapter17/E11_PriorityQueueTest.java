package chapter17;

import java.util.PriorityQueue;
import java.util.Random;

public class E11_PriorityQueueTest extends PriorityQueue<E11_PriorityQueueTest.Item> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2458332790717377393L;

	static class Item implements Comparable<Item>{
		private int num;
		private static Random rand = new Random(47);
		public Item() {
			super();
			this.num = rand.nextInt(1000);
		}

		@Override
		public int compareTo(Item o) {
			return Integer.compare(this.num, o.num);
		}

		@Override
		public String toString() {
			return "Item [num=" + num + "]";
		}
		
		
	}
	
	public void addSomeItem(int size) {
		for(int i = 0;i < size; ++i) {
			this.add(new Item());
		}
	}
	
	public static void main(String[] args) {
		E11_PriorityQueueTest p = new E11_PriorityQueueTest();
		p.addSomeItem(10);
		while(!p.isEmpty()) {
			System.out.println(p.remove());
		}
	}
}
