package chapter15;

import java.util.Iterator;

/*
 * ���ݸ�ϰ�������ģʽ�����ǿ���֪�������ඨ��һ���ӿڳ��ж���Ȼ��ͬ����ʵ�ֲ�ͬ�Ĳ������࣬�����ڴ���ʱ��������
 * ��ʽ�����ø����м̳е����������򣬶��ڸ�����ͨ������������ת�����ýӿڶ������ڲ�ͬ�Ķ���ӵ�в�ͬ��ʵ�֣��ɴ�ʵ��
 * ��̬��ͬʱ�������˴��롣
 * 
 */

interface Combiner<T> {T combine(T x, T y);}
interface UnaryFunction<R,T> {R function(T x);}
interface Collector<T> extends UnaryFunction<T,T>{ T result();}
interface UnaryPredicate<T> {boolean test(T x);}

public class Functional {
	//���ﶨ��Ķ��ǽ��ܽӿڲ����ľ�̬������
	/**
	 * ����ĺ��������൱�ڸ�����нӿڶ������ǿ��Դ��벻ͬ�Ĳ���ʵ�֣�������ͬ������·ִ�С�
	 * ����ǲ������ģʽ��һ�����֡�
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
	
	
	//������ǲ�ͬ���Եľ���ʵ�����ࡣ�ɴ�ʵ�ִ��븴�á�ʵ����һ������Ķ�̬��
	
	
}
