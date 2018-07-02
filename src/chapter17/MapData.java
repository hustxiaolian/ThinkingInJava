package chapter17;

import java.util.LinkedHashMap;

import chapter15.Generator;

public class MapData<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 7206026559537597030L;
	
	public MapData(Generator<Pair<K,V>> gen, int size) {
		for(int i = 0;i < size;++i) {
			Pair<K,V> p = gen.next();
			put(p.key, p.val);
		}
	}
	
	public MapData(Generator<K> genk, Generator<V> genv, int size) {
		for(int i = 0;i < size;++i) {
			this.put(genk.next(), genv.next());
		}
	}
	
	public MapData(Generator<K> genk ,V val, int size) {
		for(int i = 0;i < size;++i) {
			put(genk.next(), val);
		}
	}
}
