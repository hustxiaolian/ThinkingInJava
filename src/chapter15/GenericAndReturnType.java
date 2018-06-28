package chapter15;

public class GenericAndReturnType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f(new GetterTest());
	}
	
	static void f(Getter g) {
		Getter result = g.get();
		
	}

}

interface GenericGetter<T extends GenericGetter<T>>{//基类接口，这个接口貌似没法直接用，必须用具体的接口类型继承下。
	T get();
}

interface Getter extends GenericGetter<Getter> {}//利用自限定子类接口，它获得get方法，但是其中T变成Getter类型，限定在具体的接口类型

class GetterTest implements Getter{

	@Override
	public Getter get() {
		// TODO Auto-generated method stub
		return null;
	}
	
}