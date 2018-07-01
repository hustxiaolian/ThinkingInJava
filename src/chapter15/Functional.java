package chapter15;

import java.util.Iterator;

/*
 * 根据复习策略设计模式，我们可以知道：父类定义一个接口持有对象，然后不同策略实现不同的策略子类，子类在创建时或者其他
 * 方式，设置父类中继承得来的数据域，而在父类中通过代理，将调用转发给该接口对象，由于不同的对象拥有不同的实现，由此实现
 * 多态，同时，复用了代码。
 * 
 */

interface Combiner<T> {T combine(T x, T y);}
interface UnaryFunction<R,T> {R function(T x);}
interface Collector<T> extends UnaryFunction<T,T>{ T result();}
interface UnaryPredicate<T> {boolean test(T x);}

public class Functional {
	//这里定义的都是接受接口参数的静态方法，
	/**
	 * 这里的函数，就相当于父类持有接口对象，我们可以传入不同的策略实现，它按照同样的套路执行。
	 * 这就是策略设计模式的一种体现。
	 * @param seq
	 * @param combiner
	 * @return
	 */
	public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
		Iterator<T> iter = seq.iterator();
		if(iter.hasNext()) {
			T result = iter.next();
			while(iter.hasNext())
				result = combiner.combine(result, iter.next());
			return result;
		}
		return null;
	}
	
	public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
		for(T t:seq)
			func.function(t);
		return func;
	}
	
	
	//下面就是不同策略的具体实现子类。由此实现代码复用。实现另一种意义的多态。
	
	
}
