package chapter15;

/**
 * 生成器接口，所有实现该接口的类，都实现next()方法返回相应的对象
 * @author 25040
 *
 * @param <T>
 */
public interface Generator<T> {
	T next();
}


