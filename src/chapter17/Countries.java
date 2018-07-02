package chapter17;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Countries {
	public static final String[][] DATA = {};
	
	private static class FlyweightMap extends AbstractMap<String, String>{
		
		private static class Entry implements Map.Entry<String, String>{
			int index;
			
			public Entry(int index) {
				super();
				this.index = index;
			}
			
			public boolean equals(Object o) {
				return DATA[index][0].equals(o);
			}

			@Override
			public String getKey() {
				return DATA[index][0];
			}

			@Override
			public String getValue() {
				return DATA[index][1];
			}

			@Override
			public String setValue(String value) {
				throw new RuntimeException("unsupport operation!");
			}
			
		}
		
		static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
			private int size;
			
			public EntrySet(int size) {
				super();
				if(size < 0)
					this.size = 0;
				else if(size > DATA.length)
					this.size = DATA.length;
				else
					this.size = size;
			}

			@Override
			public Iterator<java.util.Map.Entry<String, String>> iterator() {
				return new Iterator<Map.Entry<String,String>>() {
					private Entry entry = new Entry(-1);
					@Override
					public boolean hasNext() {
						return entry.index < size - 1;
					}

					@Override
					public java.util.Map.Entry<String, String> next() {
						entry.index++;
						return entry;
					}
				};
			}

			@Override
			public int size() {
				return size;
			}
			
		}
		
		private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

		@Override
		public Set<java.util.Map.Entry<String, String>> entrySet() {
			return entries;
		}
	}
	
	static Map<String, String> select(final int size){
		return new FlyweightMap() {
			public Set<Map.Entry<String, String>> entrySet(){
				return new EntrySet(size);
			}
		};
	}
	
	static Map<String, String> map = new FlyweightMap();
	
	public static Map<String ,String> capitals(){
		return map;
	}
	
	public static Map<String ,String> capitals(int size){
		return select(size);
	}
	
	static List<String> names = new ArrayList<>(map.keySet());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
