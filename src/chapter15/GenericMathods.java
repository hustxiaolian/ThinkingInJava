package chapter15;

public class GenericMathods {
	public static <T> void f(T x) {
		System.out.println(x.getClass().getName() + " " + x);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f(1);
	}

}
