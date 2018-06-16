package chapter10;

public class Demo15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleChildClass.get(5).f();
	}
}

class E15SimpleClass{
	public E15SimpleClass(int i) {
		System.out.println("simpleclass:" + i);
	}
	public void f() {}
}

class SimpleChildClass{
	static E15SimpleClass get(int i) {
		return new E15SimpleClass(i) {
			public void f() {
				System.out.println("no name class");
			}
		};
	}
}
