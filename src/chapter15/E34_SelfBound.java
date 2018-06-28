package chapter15;

public abstract class E34_SelfBound<T extends E34_SelfBound<T>> {
	T element;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	T getOldAndSet(T arg) {
		System.out.println("f before");
		T t = set(arg);
		System.out.println("f after");
		return t;
	}
	abstract T set(T arg);

}

class E34_SelfBoundTest extends E34_SelfBound<E34_SelfBoundTest>{

	@Override
	E34_SelfBoundTest set(E34_SelfBoundTest arg) {
		E34_SelfBoundTest old = element;
		element = arg;
		return old;
	}
	
	public static void main(String[] args) {
		System.out.println(new E34_SelfBoundTest().getOldAndSet(new E34_SelfBoundTest()));
	}
	
}
