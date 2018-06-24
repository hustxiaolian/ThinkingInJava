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
		writeExact(fruits, new Apple());//ע�⵽�����Ǵ��,Ҳ������˵�����ܹ�ʶ��̳С�����������ʧ��ǰ��󲿷����ۻ�����ȷ�ġ�
		//�ٴ�ǿ��ע������������������ͺ��������ж��������
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
