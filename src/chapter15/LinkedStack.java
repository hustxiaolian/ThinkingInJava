package chapter15;

public class LinkedStack<T> {
	private static class Node<U>{
		U item;
		Node<U> next;
		Node() {
			item = null;
			next = null;
		}
		Node(U item, Node<U> next) {
			super();
			this.item = item;
			this.next = next;
		}
		
		boolean isEnd() {
			return item == null && next == null;
		}
	}
	
	private Node<T> top = new Node<T>();
	
	public void push(T item) {
		top = new Node<T>(item, top);
	}
	
	public T pop() {
		T pop = top.item;
		if(!top.isEnd())//当堆栈为空时，还是可以调用，但是你会得到null
			top = top.next;
		return pop;
	}
}
