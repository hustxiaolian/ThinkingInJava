package chapter15;

import java.util.HashMap;
import java.util.Map;

public class E24_FactoryContainer {
	private Map<String, Factory<?>> map = new HashMap<>();//当本身我也不确定要使用什么类型时候，我们直接指定？
	
	public void addFactory(String name, Factory<?> f) {
		map.put(name, f);
	}
	
	public Object createNew(String name, int args) {
		Factory<?> f = map.get(name);
		return f.create(args);
	}
	
	public static void main(String[] args) {
		E24_FactoryContainer fc = new E24_FactoryContainer();
		fc.addFactory("Widget", new Widget.Factory1());
		Widget w = (Widget) fc.createNew("Widget", 1);
		System.out.println(w);
		System.out.println(fc.createNew("Widget", 1));//因为object有toString方法，所以不需要转型，
	}

}

class Widget{
	private final int id;

	Widget(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Widget [id=" + id + "]";
	}
	
	public static class Factory1 implements Factory<Widget>{

		@Override
		public Widget create() {
			return new Widget(-1);
		}

		@Override
		public Widget create(int arg) {
			return new Widget(arg);
		}
		
	}
}
