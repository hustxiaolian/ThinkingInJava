package chapter8;

public class Demo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D10base d = new D10child();
		d.m1();
	}

}

class D10base{
	public void m1() {
		System.out.println("m1");
		m2();
	}
	
	public void m2() {
		System.out.println("m2");
	}
}

class D10child extends D10base{
	public void m2() {
		System.out.println("child m2");
	}
}

