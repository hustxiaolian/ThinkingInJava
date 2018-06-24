package chapter15;

import java.util.Arrays;
import java.util.List;

public class GenericReading {

	static <T> T readExact(List<T> lst){
		return lst.get(0);
	}
	
	static List<Apple> apples = Arrays.asList(new Apple());
	static List<Fruit> fruits = Arrays.asList(new Fruit());
	
	static void f1() {
		Apple a = readExact(apples);
		Fruit f = readExact(fruits);
		Fruit f2 = readExact(fruits);
	}
	
	static class Reader<T>{
		T readExact(List<T> list) {return list.get(0); }
	}
	
	static void f2() {
		Reader<Fruit> fruitReader = new Reader<>();
		Fruit f = fruitReader.readExact(fruits);
		
		//Fruit f1 = fruitReader.readExact(apples);List<Fruit>和List<Apple>不是一个类型，也不存在他们持有对象之间的继承关系
	}
	
	static class CovariantReader<T> {
		T readCovariant(List<? extends T> flst) {
			return flst.get(0);
		}
	}
	
	static void f3() {
		CovariantReader<Fruit> fcr = new CovariantReader<>();
		Fruit a = fcr.readCovariant(apples);
		Fruit f = fcr.readCovariant(fruits);
	}
	
	public static void main(String[] args) {
		f1();
		f2();
		f3();
		System.out.println("done");
	}
}
