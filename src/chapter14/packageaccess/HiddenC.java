package chapter14.packageaccess;

import chapter14.A;

class C implements A{

	@Override
	public void f() {
		// TODO Auto-generated method stub
		System.out.println("C.A()");
	}
	
	public void g() {
		System.out.println("C.B()");
	}
	
	private void w() {
		System.out.println("C.w()");
	}
}

public class HiddenC{
	public static A makeA() {
		return new C();
	}
}
