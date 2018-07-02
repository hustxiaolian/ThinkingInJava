package chapter17;

import java.util.ArrayList;
import java.util.Collection;

import chapter15.Generator;

public class CollectionData<T> extends ArrayList<T>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7786591205283073583L;

	public CollectionData(Generator<T> gen, int size) {
		for(int i = 0;i < size;++i)
			add(gen.next());
	}
	
	public static <T> CollectionData<T> list(Generator<T> gen, int size){
		return new CollectionData<>(gen, size);
	}
	
	public static <T> void fill(Collection<T> col, Generator<T> gen, int size){
		for(int i = 0;i < size; ++i)
			col.add(gen.next());
	}
}
