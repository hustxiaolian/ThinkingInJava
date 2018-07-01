package chapter15;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Apply {
	/**
	 * ע�⵽���������������Ϣ��Ϊʲô����Ҫ��������������Ϣ��
	 * ����TΪ���ж�������ͱ�������ôS���Ǳ�֤������ô����������ʵ����Iterable�ӿڣ��ɴ˸��߱��������ҽ��ܵ����seq
	 * ����ʵ����Iterable�ӿڣ�ͬʱ����������Ϣ���ݳ��ж�������͵�����ȡ��
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
	 * �ú��������û����뱻���������class���泣����
	 * ���ڸö���ΪT����ô����class�����泣��ֻ�п�����
	 * @param type
	 * @param size
	 */
	public FilledList(Class<? extends T> type, int size) {
		try {
			for(int i = 0;i < size;++i)
				this.add(type.newInstance());//��������˱������Ķ���ӵ��Ĭ�ϵ��޲ι�����
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
