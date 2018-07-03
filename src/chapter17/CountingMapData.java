package chapter17;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountingMapData extends AbstractMap<Integer, String> {
	private int size;
	private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
	
	
	public CountingMapData(int size) {
		super();
		this.size = size < 0 ? 0 : size;
	}
	
	private static class Entry implements Map.Entry<Integer, String>{
		int index;//就是这里实现了享元设计模式，使用外部索引（数组索引）来替代原始内容
		public Entry(int index) {
			super();
			this.index = index;
		}
		
		public boolean equals(Object o) {
			return Integer.valueOf(index).equals(o);
		}
		
		public int hashCode() {
			return Integer.valueOf(index).hashCode();
		}

		@Override
		public Integer getKey() {
			return index;
		}

		@Override
		public String getValue() {
			return chars[index];
		}

		@Override
		public String setValue(String value) {
			throw new RuntimeException("unsupport operation!");
		}
	}
	
	private static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> implements Iterable<Map.Entry<Integer, String>>{
		private int size;
		
		public EntrySet(int size) {
			super();
			if(size < 0)
				this.size = size;
			else if(size > chars.length)
				this.size = chars.length;
			else
				this.size = size;
		}

		@Override
		public Iterator<java.util.Map.Entry<Integer, String>> iterator() {
			return new Iterator<Map.Entry<Integer,String>>() {
				private Entry entry = new Entry(-1);//疑问：匿名内部类可以传入参数 ，完成另一种形式的构造吗
				@Override
				public boolean hasNext() {
					return entry.index < size;
				}

				@Override
				public java.util.Map.Entry<Integer, String> next() {
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
	
	public Set<java.util.Map.Entry<Integer, String>> entrySet(int size){
		return new EntrySet(size);
	}
	
	@Override
	public Set<java.util.Map.Entry<Integer, String>> entrySet() {
		/*
		Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<>();
		for(int i = 0;i < size;++i) {
			entries.add(new Entry(i));
		}
		return null;
		*/
		return entrySet(chars.length);
	}

}
