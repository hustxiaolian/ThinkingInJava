package chapter15;

public interface Factory<T> {
	T create();
	T create(int arg);
}
