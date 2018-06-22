package chapter15;

public class E20_classTwo {
	public static <T extends E20_interface> void f(T obj) {
		obj.f();
		obj.g();
	}
	
	public static void main(String[] args) {
		f(new E20_classOne());
	}
}
