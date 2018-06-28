package chapter15;

/**
 * 
 * @author 25040
 *
 * @param <T>
 * 这里有点晕，我先自己尝试理解一下：
 * 该新类有个类型参数，它是继承自
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

class A extends SelfBounded<A> {}//这就是基类希望的行为
class B extends SelfBounded<A> {}


