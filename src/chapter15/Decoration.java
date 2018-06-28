package chapter15;

import java.util.Date;

class Base{
	private String value;
	public void set(String val) {
		value = val;
	}
	public String get() {return value;}
}

class Decorator extends Base{
	protected Base base;

	public Decorator(Base base) {
		super();
		this.base = base;
	};
	
	public void set(String val) {base.set(val);}
	public String get() {return base.get(); }
}

class TimeStampedDecorator extends Decorator{
	private final long timeStamp;
	public TimeStampedDecorator(Base base) {
		super(base);
		timeStamp = new Date().getTime();
	}
	public long getTimeStamp() {return timeStamp;}
}

class SearialNumberDecorator extends Decorator{
	
	private static int count = 1;
	private final int id = count++;
	
	public SearialNumberDecorator(Base base) {
		super(base);
	}
	
	public long getSearialNumber() {return id;}
}

public class Decoration {
	public static void main(String[] args) {
		//原来如此，java i/o里面出现的嵌套就是这样实现的。通过层层嵌套完成功能的叠加。最里面的类完成最核心的功能，
		//外围的类就像是装饰器一样，可以组合完成更多的迭代功能。但是书中说只有最外层可见。不知道i/o是怎么实现的。
		TimeStampedDecorator t = new TimeStampedDecorator(new Base());
		TimeStampedDecorator t2 = new TimeStampedDecorator(new SearialNumberDecorator(new Base()));
		t2.getTimeStamp();
		//t2.getSearailNumber不可见？因为这个类本质上就是TimeStampedDecorator类，而getSearialNumber是定义在另一个装饰器类中
		//尽管传递过去的它的具体类型确实是这个，但是在构造时完成了向上转型，成了Base
		
		SearialNumberDecorator s = new SearialNumberDecorator(new Base());
		SearialNumberDecorator s2 = new SearialNumberDecorator(new TimeStampedDecorator(new Base()));
		
		s.getSearialNumber();//装饰器添加功能
		s.get();
		s.set("..");
		s2.getSearialNumber();
		//s2.getTimeStamp()并不可见，原因同上。
	}
}
