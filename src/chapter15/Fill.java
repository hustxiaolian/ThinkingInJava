package chapter15;

import java.util.Collection;

public class Fill {
	public static <T> void fill(Collection<T> col, Class<? extends T> cls, int size) {
		try {
			for(int i = 0; i < size;i++) 
				col.add(cls.newInstance());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
