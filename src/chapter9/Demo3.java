package chapter9;

public class Demo3 {

	public static void main(String[] args) {
		D3child c = new D3child();
		c.print();
	}

}

abstract class D3base{
	public D3base() {
		print();
	}
	public abstract void print();
}

class D3child extends D3base{
	private int i = 1;
	@Override
	public void print() {
		System.out.println("i=" + i);
	}
	
}