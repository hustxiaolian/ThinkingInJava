package chapter17;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JComboBox.KeySelectionManager;

import sun.net.www.http.KeepAliveCache;

/**
 * 继承map接口的抽象基类。避免过多的代码。
 * @author 25040
 *
 * @param <K>
 * @param <V>
 */
public class SlowMap<K,V> extends AbstractMap<K, V> {
	private List<K> keys = new ArrayList<>();
	private List<V> vals = new ArrayList<>();
	
	public V put(K key, V value) {
		V old = vals.get(keys.indexOf(key));
		if(!keys.contains(key)) {
			keys.add(key);
		}
		else {
			vals.set(keys.indexOf(key), value);
		}
		return old;
	}
	
	public V get(Object key) {//这里我们必须覆盖基类的put方法，不能声明为public V get(K put),因为类型擦除
		if(!keys.contains(key))
			return null;
		return vals.get(keys.indexOf(key));
	}	
	
	private class Entry implements Map.Entry<K, V>{
		private int index;
		public Entry(int index) {
			super();
			this.index = index;
		}

		@Override
		public K getKey() {
			return keys.get(index);
		}

		@Override
		public V getValue() {
			return vals.get(index);
		}

		@Override
		public V setValue(V value) {
			V old = vals.get(index);
			vals.set(index, value);
			return old;
		}
	}
	
	public class EntrySet extends AbstractSet<Map.Entry<K, V>> implements Iterable<Map.Entry<K, V>>{
		private int size;
		
		public EntrySet(int size) {
			super();
			this.size = size;
		}

		private Entry currEntry = new Entry(-1);
		@Override
		public Iterator<java.util.Map.Entry<K, V>> iterator() {
			return new Iterator<Map.Entry<K,V>>() {
				@Override
				public boolean hasNext() {
					return currEntry.index < size;
				}

				@Override
				public java.util.Map.Entry<K, V> next() {
					currEntry.index++;
					return currEntry;
				}
				
			};
		}

		@Override
		public int size() {
			return size;
		}
		
	}
	
	public Set<java.util.Map.Entry<K, V>> E16_entrySet(){
		return new EntrySet(keys.size());
	}
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<>();
		Iterator<K> keyIter = keys.iterator();
		Iterator<V> valIter = vals.iterator();
		while(keyIter.hasNext()) {
			set.add(new MapEntry(keyIter.next(), valIter.next()));
		}
		return set;
	}
	
}

class MapEntry<K,V> implements Map.Entry<K, V>{
	public K key;
	public V value;
	
	
	public MapEntry(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapEntry other = (MapEntry) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	
}
