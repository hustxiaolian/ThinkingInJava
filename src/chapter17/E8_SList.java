package chapter17;

public class E8_SList<T> {
	private Node<T> header;
	public E8_SList() {
		super();
		header = new Node<>(null, null);
	}

	private static class Node<T>{
		T val;
		Node<T> next;
		public Node(T val, Node<T> next) {
			super();
			this.val = val;
			this.next = next;
		}
	}
	
	public SListIterator iterator() {
		return new SListIterator();
	}
	
	public class SListIterator{
		private Node<T> curr = header;
		private Node<T> pre;
		private boolean flag = false;
		
		public boolean hasNext() {
			return curr.next != null;
		}
		
		public T next() {
			if(hasNext()) {
				pre = curr;
				curr = curr.next;
				flag = true;
				return curr.val;
			}
			return null;
		}
		
		public void add(T newVal) {
			Node<T> newOne = new Node<T>(newVal, curr.next);
			curr.next = newOne;
			next();
		}
		
		public T remove() {
			if(!flag)
				throw new RuntimeException("±ÿ–Îœ»next£¨‘Ÿremove");
			T old = curr.val;
			pre.next = curr.next;
			curr = pre.next;
			flag = false;
			return old;
		}
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		E8_SList<T>.SListIterator iter = this.iterator();
		while(iter.hasNext())
			sb.append(iter.next()).append(",");
		sb.delete(sb.length() - 1,sb.length());
		sb.append("]");
		return sb.toString();
	}
	

	public static void main(String[] args) {
		E8_SList<Integer> list = new E8_SList<>();
		E8_SList<Integer>.SListIterator iter = list.iterator();
		
		for(int i = 0;i < 10; ++i)
			iter.add(i);
		
		iter = list.iterator();
		iter.add(11);
		iter.next();
		iter.add(12);
		
		
		
		System.out.println(list);
	}
	
}
