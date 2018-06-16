package chapter10;

/**
 * 
 * @author 25040
 * 梳理一下。我定义了一个接口，然后我在第一个类中定义了一个protected内部类实现了该接口，在子类使用返回了
 * 接口类型引用，而实际上的对象确实第一个类定义的内部类对象，但是这个内部类对外部是不可访问的。
 * 因此隐藏了实现的细节。秒
 */
public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface Exercise6{
	void f();
}

class SimpleClass{
	protected class Inner implements Exercise6{
		public Inner() {
			
		}
		
		@Override
		public void f() {
			// TODO Auto-generated method stub
			
		}
		
	}
}

class SimpleClass2 extends SimpleClass{
	public Exercise6 get() {
		return new Inner();
	}
}