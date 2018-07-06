package chapter17;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
	private int size = 997;//这里应该是素数。
	@SuppressWarnings("unchecked")
	private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[size];
	
	public V put(K key, V val) {
		V old = null;
		int index = Math.abs(key.hashCode()) %  size;
		if(buckets[index] == null)
			buckets[index] = new LinkedList<>();
		LinkedList<MapEntry<K,V>> currList = buckets[index];
		MapEntry<K,V> pair = new MapEntry<>(key, val);
		ListIterator<MapEntry<K,V>> iter = currList.listIterator();
		boolean found = false;
		while(iter.hasNext()) {
			MapEntry<K,V> iPair = iter.next();
			if(iPair.getKey().equals(key)) {
				old = iPair.getValue();
				found = true;
				iter.set(pair);
				break;
			}
		}
		if(!found)
			currList.addLast(pair);
		return old;
	}
	
	public V get(Object key) {
		V ret = null;
		int index = Math.abs(key.hashCode()) % size;
		if(buckets[index] != null) {
			LinkedList<MapEntry<K,V>> currList = buckets[index];
			ListIterator<MapEntry<K,V>> iter = currList.listIterator();//这里应该像书上那样用foreach循环比较好
			while(iter.hasNext()) {
				MapEntry<K,V> iPair = iter.next();
				if(iPair.getKey().equals(key))
					return iPair.getValue();
			}
		}
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Map.Entry<K,V>> set = new HashSet<>();
		
		for(LinkedList<MapEntry<K,V>> bucket : buckets) {
			if(bucket == null) 
				continue;
			for(MapEntry<K,V> entry : bucket) {
				set.add(entry);
			}
		}
		
		return set;
	}

}
