package chapter15;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
	
	public static <T> List<T> makeList(T... args){
		List<T> result = new ArrayList<>();
		for (T t : args) {
			result.add(t);
		}
		return result;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(makeList("adadadad".split("")));
	}

}
