package chapter15;

public class E9_GenericMethods {
	public static <A,B,C> void f(A x, B y, C z) {
		System.out.println(x.getClass().getName() + " " + x);
		System.out.println(y.getClass().getName() + " " + y);
		System.out.println(z.getClass().getName() + " " + z);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f(1.0,1.0f,1L);
	}

}
