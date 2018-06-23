package chapter15;

public class E25_GenericBoundTest {

	public static <T extends E25_interface1> void f(T obj){
		obj.f();
	}
	
	public static <T extends E25_interface2> void g(T obj){
		obj.g();
	}
	
	public static void main(String[] args) {
		E25_Test1 t = new E25_Test1();
		f(t);
		g(t);
	}
}

interface E25_interface1{
	void f();
}

interface E25_interface2{
	void g();
}

class E25_Test1 implements E25_interface1, E25_interface2{

	@Override
	public void g() {
		// TODO Auto-generated method stub
		System.out.println("g()");
	}

	@Override
	public void f() {
		// TODO Auto-generated method stub
		System.out.println("f()");
	}
	
}