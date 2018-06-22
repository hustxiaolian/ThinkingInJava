package chapter14;

public class InterfaceViolation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new B();
		a.f();
		if(a instanceof B)
			((B) a).g();
	}

}
