package chapter15;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	
	private Class<?>[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
	private static Random rand = new Random();
	private int size = 0;

	CoffeeGenerator(int size) {
		super();
		this.size = size;
	}
	
	

	@Override
	public Coffee next() {
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterator<Coffee> iterator() {
		// TODO Auto-generated method stub
		return new CofferIterator();
	}
	
	public class CofferIterator implements Iterator<Coffee> {
		private int count = size;
		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();//调用外部对象的next;
		}

	}

}
