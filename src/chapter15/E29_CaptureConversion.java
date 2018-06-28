package chapter15;

import java.util.ArrayList;
import java.util.List;

public class E29_CaptureConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static void f1(Holder<List<?>> h) {
		List<?> list = h.getValue();
		System.out.println(h.equals(list));
		
		Integer i = (Integer) list.get(0);
		System.out.println(i);
		System.out.println(list.contains(i));//查看jdk发现List这两个方法都是Object
		System.out.println(list.remove(i));
		h.setValue(new ArrayList<Float>());
	}
	
	public static void f2(List<Holder<?>> list) {
		Holder<?> holder = list.get(0);
		
	}

}
