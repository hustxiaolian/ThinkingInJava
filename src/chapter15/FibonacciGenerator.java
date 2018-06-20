package chapter15;

public class FibonacciGenerator implements Generator<Integer> {
	private int count = 0;
	@Override
	public Integer next() {
		return fib(count++);
	}
	private Integer fib(int i) {
		if(i < 2)
			return 1;
		return fib(i - 1) + fib(i - 2);
	}
}

class FibonacciGenerator2 implements Generator<Integer>{
	private int first = 1;
	private int second = 1;
	int n = 1;
	
	
	@Override
	public Integer next() {
		if(n < 2)
			return 1;
		return fib();
	}

	private Integer fib() {
		++n;
		int result = first + second;
		first = second;
		second = result;
		return result;
	}
	
}
