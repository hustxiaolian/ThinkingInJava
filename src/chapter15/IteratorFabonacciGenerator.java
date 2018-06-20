package chapter15;

import java.util.Iterator;

/**
 * 
 * @author 25040
 * �̳�����ʵ�ֵ�쳲�������������Ȼ��������������ģʽ��ʵ��Iterable�ӿڡ�
 */
public class IteratorFabonacciGenerator extends FibonacciGenerator implements Iterable<Integer> {
	
	private int n;
	public IteratorFabonacciGenerator(int n) {
		super();
		this.n = n;
	}
	@Override
	/**
	 * ֱ���������ڲ���ķ�ʽ��ʵ��
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
