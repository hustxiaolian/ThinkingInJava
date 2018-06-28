package chapter15;

public interface SelfBoundHolderInterface<T extends SelfBoundHolderInterface<T>> {
	void set(T args);
	T get();
}
