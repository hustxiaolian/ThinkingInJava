package chapter15;

public class E4_LinkedStack<T> {
	private class Node{
		public T item;
		Node next;
		Node() {
			item = null;
			next = null;
		}
		Node(T item, Node next) {
			super();
			this.item = item;
			this.next = next;
		}
		
		boolean isEnd() {
			return item == null && next == null;
		}
	}
	
	private Node top = new Node();
	
	public void push(T item) {
		top = new Node(item, top);
	}
	
	public T pop() {
		T pop = top.item;
		if(!top.isEnd())//当堆栈为空时，还是可以调用，但是你会得到null
			top = top.next;
		return pop;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
