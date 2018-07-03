package chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class E6_Unsupported {
	
	static void test(String msg, List<String> l) {
		System.out.println("------------" + msg + "-------------");
		List<String> subList = new ArrayList<>(l.subList(1, 8));
		try {
			l.add(0, "Test");
		} catch (Exception e) {
			System.out.println("add(index, element)" + e);
		}
		
		try {
			l.addAll(0, subList);
		} catch (Exception e) {
			System.out.println("addAll(index, c)" + e);
		}
		
		try {
			l.remove(0);
		} catch (Exception e) {
			System.out.println("remove(index)" + e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
		test("modifiable copy", new ArrayList<>(list));
		test("Arrays.asList", list);
		test("unmodifibale copy", Collections.unmodifiableList(new ArrayList<>(list)));
	}

}
