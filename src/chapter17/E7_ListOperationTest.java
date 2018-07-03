package chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class E7_ListOperationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" "));
		List<String> list2 = Arrays.asList("1 2 3 4 5 6 7 8 9".split(" "));
		ArrayList<String> t1 = new ArrayList<>(list);
		LinkedList<String> t2 = new LinkedList<>(list2);
		
		Iterator<String> iter1 = t1.iterator();
		while(iter1.hasNext())
			System.out.print(iter1.next() + " ");
		System.out.println();
		iter1 = t2.iterator();
		while(iter1.hasNext()) {
			System.out.print(iter1.next() + " ");
		}
		System.out.println();
		ListIterator<String> iter2 = t1.listIterator();
		ListIterator<String> iter3 = t2.listIterator();
		
		while(iter2.hasNext() && iter3.hasNext()) {
			iter2.add(iter3.next());
			iter2.next();
		}
		
		System.out.println(t1);
		
	} 

}
