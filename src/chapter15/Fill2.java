package chapter15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Fill2 {
	public static <T> void fill(Addable<T> addable, Class<? extends T> cls, int size) {
		try {
			for(int i = 0;i < size;++i)
				addable.add(cls.newInstance());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static <T> void fill(Addable<T> addable, Generator<T> gen, int size) {
		for(int i = 0;i < size;++i)
			addable.add(gen.next());
	}
}

class AddableCollectionAdapter<T> implements Addable<T>{
	private Collection<T> col;
	
	
	public AddableCollectionAdapter(Collection<T> col) {
		super();
		this.col = col;
	}

	@Override
	public void add(T item) {
		// TODO Auto-generated method stub
		col.add(item);
	}
}

class Adapter{
	public static <T> Addable<T> collectionAdapter(Collection<T> c){
		return new AddableCollectionAdapter<>(c);
	}
}

class FillTest{
	public static void main(String[] args) {
		List<Coffee> cofs = new ArrayList<>();
		Fill2.fill(Adapter.collectionAdapter(cofs), Coffee.class, 3);//这种优雅，可以将常用的适配器都放在这个类下，定义重载的静态的方法
		Fill2.fill(new AddableCollectionAdapter<>(cofs), Coffee.class, 2);
	}
}
