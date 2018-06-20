package chapter15;

import java.util.Iterator;

/**
 * 
 * @author 25040
 * 通过组合的方式来实现适配器，在原类对象实现Generator的基础上实现Iterator
 */
public class CombinationFibonacciGenerator implements Iterable<Integer> {
	private FibonacciGenerator fg;
	private int n ;
	CombinationFibonacciGenerator(FibonacciGenerator fg, int n) {
		super();
		this.fg = fg;
		this.n = n;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>() {
			
			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				--n;
				return fg.next();
			}
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return n > 0;
			}
		};
	}

}
