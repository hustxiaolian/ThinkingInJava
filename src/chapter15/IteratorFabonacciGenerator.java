package chapter15;

import java.util.Iterator;

/**
 * 
 * @author 25040
 * 继承上面实现的斐波那契生成器，然后再利用适配器模式来实现Iterable接口。
 */
public class IteratorFabonacciGenerator extends FibonacciGenerator implements Iterable<Integer> {
	
	private int n;
	public IteratorFabonacciGenerator(int n) {
		super();
		this.n = n;
	}
	@Override
	/**
	 * 直接用匿名内部类的方式来实现
	 */
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int count = n;
			@Override
			public boolean hasNext() {
				return count > 0;
			}

			@Override
			public Integer next() {
				--count;
				return IteratorFabonacciGenerator.this.next();
			}
			
		};
	}

}
