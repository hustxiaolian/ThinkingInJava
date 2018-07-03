package chapter17;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class E2_ACountries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String,String> map = new TreeMap<>(Countries.capitals());//ÄÑ¹ÖÐèÒªTreeSet
		TreeSet<String> set = new TreeSet<>(Countries.names());
		String b = null;
		for(String s:map.keySet()) {
			if(s.startsWith("B")) {
				b = s;
				break;
			}
		}
		
		Map<String, String> aMap = map.headMap(b);
		Set<String> aSet = set.headSet(b);
		
	}

}
