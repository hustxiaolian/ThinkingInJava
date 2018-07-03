package chapter17;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class E3_SetNoRepeatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<>();
		Set<String> set1 = new TreeSet<>();
		Set<String> set2 = new LinkedHashSet<>();
		for(int i = 0;i < 10;++i) {
			set.addAll(Countries.names(10));
		}
	}

}
