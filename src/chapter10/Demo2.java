package chapter10;

public class Demo2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sequence seq = new Sequence(3);
		seq.add(new StringHolder());
		seq.add(new StringHolder());
		seq.add(new StringHolder());
		Selector iter = seq.selector();
		while(!iter.end()) {
			System.out.println(iter.current());
			iter.next();
		}
	}

}

interface Selector{
	boolean end();
	Object current();
	void next();
}

class Sequence{
	private Object[] items;
	private int next = 0;
	public Sequence(int size) {
		items = new Object[size];
	}
	public void add(Object x) {
		if(next < items.length) {
			items[next++] = x;
		}
	}
	
	public Selector selector() {
		return new SequenceSelector();
	}
	
	private class SequenceSelector implements Selector{
		private int i = 0;
		@Override
		public boolean end() {
			return i == items.length;
		}

		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public void next() {
			if(!end())
				i++;
		}
		
		public Sequence getOuter() {
			return Sequence.this;
		}
	}
}

class StringHolder{
	String s = "xiaolian";
	public String toString() {
		return s;
	}
}
