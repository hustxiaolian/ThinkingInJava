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
		//ԭ����ˣ�java i/o������ֵ�Ƕ�׾�������ʵ�ֵġ�ͨ�����Ƕ����ɹ��ܵĵ��ӡ�����������������ĵĹ��ܣ�
		//��Χ���������װ����һ�������������ɸ���ĵ������ܡ���������˵ֻ�������ɼ�����֪��i/o����ôʵ�ֵġ�
		TimeStampedDecorator t = new TimeStampedDecorator(new Base());
		TimeStampedDecorator t2 = new TimeStampedDecorator(new SearialNumberDecorator(new Base()));
		t2.getTimeStamp();
		//t2.getSearailNumber���ɼ�����Ϊ����౾���Ͼ���TimeStampedDecorator�࣬��getSearialNumber�Ƕ�������һ��װ��������
		//���ܴ��ݹ�ȥ�����ľ�������ȷʵ������������ڹ���ʱ���������ת�ͣ�����Base
		
		SearialNumberDecorator s = new SearialNumberDecorator(new Base());
		SearialNumberDecorator s2 = new SearialNumberDecorator(new TimeStampedDecorator(new Base()));
		
		s.getSearialNumber();//װ������ӹ���
		s.get();
		s.set("..");
		s2.getSearialNumber();
		//s2.getTimeStamp()�����ɼ���ԭ��ͬ�ϡ�
	}
}
