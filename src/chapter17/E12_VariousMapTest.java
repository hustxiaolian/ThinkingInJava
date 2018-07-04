package chapter17;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class E12_VariousMapTest {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>(16, 075f, true);//accessOrder参数设定是否执行LRU算法
		TreeMap<String, Integer> map2 = new TreeMap<>();
		HashMap<String, Integer> map3 = new HashMap<>();
		
		map1.put("x", 1);
		map2.put("l", 2);
		map3.put("z", 5);
	}
}
