package chapter15;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Apply {
	/**
	 * 注意到这个方法的类型信息，为什么这里要这样设置类型信息，
	 * 假设T为持有对象的类型变量，那么S就是保证无论怎么样，必须是实现了Iterable接口，由此告诉编译器，我接受的这个seq
	 * 变量实现了Iterable接口，同时它的类型信息根据持有对象的类型的来获取。
	 * @param seq
	 * @param f
	 * @param args
	 */
	public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
		try {
			for(T t : seq) {
				f.invoke(t, args);
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class Shape{
	public void rotate() {System.out.println(this + " rotate");}
	public void resize(int size) {System.out.println(this + " resize" + size);}
}

class Square extends Shape {}

class FilledList<T> extends ArrayList<T> {

	private static final long serialVersionUID = -7149156692217301333L;
	/**
	 * 该函数，让用户传入被创建对象的class字面常量，
	 * 由于该对象为T，那么它的class类字面常量只有可能是
	 * @param type
	 * @param size
	 */
	public FilledList(Class<? extends T> type, int size) {
		try {
			for(int i = 0;i < size;++i)
				this.add(type.newInstance());//这里假设了被创建的对象拥有默认的无参构造器
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class AppleTest{
	public static void main(String[] args) throws Exception {
		List<Shape> shapes = new ArrayList<>();
		for(int i = 0;i < 10;++i)
			shapes.add(new Shape());
		Apply.apply(shapes, Shape.class.getMethod("rotate"));
		Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);
		
		Apply.apply(new FilledList<>(Shape.class, 10), Shape.class.getMethod("resize"), 5);
	}
}
