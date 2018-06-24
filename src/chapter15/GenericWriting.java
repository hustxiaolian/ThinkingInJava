package chapter15;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {

	static <T> void writeExact(List<T> list, T item) {
		list.add(item);
	}
	
	static List<Apple> apples = new ArrayList<>();
	static List<Fruit> fruits = new ArrayList<>();
	
	static void f1() {
		writeExact(apples, new Apple());
		writeExact(fruits, new Apple());//注意到书上是错的,也就是它说现在能够识别继承。可能是书上失误，前面大部分言论还是正确的。
		//再次强调注意区分容器本身的类型和容器持有对象的类型
		//writeExact(apples, new Fruit());
	}
	
	static <T> void writeWithWildcard(List<? super T> list, T item) {
		list.add(item);
	}
	
	static void f2() {
		writeWithWildcard(apples, new Apple());
		writeWithWildcard(fruits, new Fruit());
		writeExact(fruits, new Apple());
	}
	
	public static void main(String[] args) {
		f1();
		f2();
		for(Fruit f : fruits) {
			System.out.println(f);
		}
	}

}
