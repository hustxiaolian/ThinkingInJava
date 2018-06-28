package chapter15;

/**
 * 
 * @author 25040
 *
 * @param <T>
 * �����е��Σ������Լ��������һ�£�
 * �������и����Ͳ��������Ǽ̳���
 */
public class SelfBounded<T extends SelfBounded<T>> {
	T element;

	SelfBounded<T> set(T arg){
		element = arg;
		return this;
	}
	
	T get() {
		return element;
	}
	
}

class A extends SelfBounded<A> {}//����ǻ���ϣ������Ϊ
class B extends SelfBounded<A> {}


