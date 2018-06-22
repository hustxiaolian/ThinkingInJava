package chapter15;

public class E10_GenericMethod {
	public static <A,B> void f(A x, B y, int z) {
		System.out.println(x.getClass().getName() + " " + x);
		System.out.println(y.getClass().getName() + " " + y);
		System.out.println("int " + z);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f(1.0f, "xiaolian", 5);
	}

}
