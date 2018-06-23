package chapter15;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class E22_CreatorWithArgs<T> {
	private Class<T> kind;

	E22_CreatorWithArgs(Class<T> kind) {
		super();
		this.kind = kind;
	}

	@SuppressWarnings("unchecked")
	public T create(int args) {
		for(Constructor<?> ctor : kind.getConstructors()) {
			Class<?>[] params = ctor.getParameterTypes();
			if(params.length == 1 && params[0] == int.class)
				try {
					return (T) ctor.newInstance(args);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					throw new RuntimeException(e);
				}
		}
		return null;
	}
	
	public static void main(String[] args) {
		E22_CreatorWithArgs<Integer> t = new E22_CreatorWithArgs<>(Integer.class);
		Integer i = t.create(10);
		System.out.println(i);
	}
}

class E22_Test {
	int i;

	E22_Test(int i) {
		super();
		this.i = i;
	}
	
}